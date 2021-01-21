package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.CartItem;
import org.csu.mypetstore.persistence.DBUtil;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-16 07:56
 **/
public class ViewSignOutServlet extends HttpServlet {

    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String INSERT ="INSERT INTO cartinfo(username,itemid,productid,description,instock,quantity,listprice,totalcost) Value (?,?,?,?,?,?,?,?);";
    Account account;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        account = (Account) session.getAttribute("account");
        Cart cart = (Cart) session.getAttribute("cart");
        Iterator<CartItem> cartItems = null;
        if(cart!=null)
        cartItems = cart.getAllCartItems();
        if(account == null && cartItems!=null){
            session.setAttribute("message","你还没有登录");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }else{

            try{
                while(cartItems.hasNext()){
                    CartItem cartItem = cartItems.next();
                    Connection connection = DBUtil.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
                    preparedStatement.setString(1,account.getUsername());
                    preparedStatement.setString(2,cartItem.getItem().getItemId());
                    preparedStatement.setString(3,cartItem.getItem().getProduct().getProductId());
                    String des = cartItem.getItem().getProduct().getDescription();
                    String[] des2 = des.split(">");
                    if(des2.length == 2)
                    preparedStatement.setString(4,des2[1]);
                    else
                        preparedStatement.setString(4,des2[0]);
                    preparedStatement.setString(5, String.valueOf(cartItem.isInStock()));
                    preparedStatement.setInt(6,cartItem.getQuantity());
                    preparedStatement.setString(7,cartItem.getItem().getListPrice().toString());
                    preparedStatement.setString(8,cartItem.getTotal().toString());
                    preparedStatement.execute();
                    DBUtil.closeStatement(preparedStatement);
                    DBUtil.closeConnection(connection);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            session.removeAttribute("cart");
            session.removeAttribute("account");
            req.getRequestDispatcher(MAIN).forward(req,resp);
        }
    }
}
