package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.*;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-16 00:06
 **/
public class MainAfterLoginServlet extends HttpServlet {

    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private static final String GET_CART_BY_USERNAME = "SELECT * FROM cartinfo WHERE username = ?";
    private static final String DELETE = "delete from cartinfo where username = ?";
    private String username;
    private String password;
    private Account account;
    private String verificationCode;
    private String trueVerificationCode;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        username = req.getParameter("username");
        password = req.getParameter("password");
        verificationCode = req.getParameter("verificationCode");
        System.out.println(username + " " + password + " " + verificationCode);
        AccountService service = new AccountService();
        HttpSession session = req.getSession();
        trueVerificationCode = (String) session.getAttribute("verCode");
        if(service.getAccount(username,password) != null){
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            if(!(Objects.equals(trueVerificationCode, verificationCode)||(Objects.equals(trueVerificationCode.toUpperCase(), verificationCode)))){
//                session.setAttribute("message","验证码错误！");
//                req.getRequestDispatcher(ERROR).forward(req,resp);

                out.print("VerFail");
                out.flush();
                out.close();
            }
            else{
                out.print("Success");
                out.flush();
                out.close();
                account = service.getAccount(username,password);
                session.setAttribute("account",account);
                session.removeAttribute("cart");
                Cart cart = new Cart();
                try {
                    Connection connection = DBUtil.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(GET_CART_BY_USERNAME);
                    preparedStatement.setString(1,account.getUsername());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while(resultSet.next()){
                        Item item = new Item();
                        Product product = new Product();
                        product.setProductId(resultSet.getString(3));
                        product.setDescription(resultSet.getString(4));
                        String des = resultSet.getString(4);
                        item.setProduct(product);
                        item.setAttribute1(des);
                        item.setItemId(resultSet.getString(2));
                        item.setQuantity(resultSet.getInt(6));
                        item.setListPrice(new BigDecimal(resultSet.getString(7)));
                        cart.addItem(item,Boolean.parseBoolean(resultSet.getString(5)));
                    }
                    DBUtil.closeStatement(preparedStatement);
                    PreparedStatement preparedStatement2 = connection.prepareStatement(DELETE);
                    preparedStatement2.setString(1,account.getUsername());
                    preparedStatement2.execute();
                    DBUtil.closeStatement(preparedStatement2);
                    DBUtil.closeConnection(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                session.setAttribute("cart",cart);
            }
        }
        else{
//            session.setAttribute("message","用户名或密码错误！");
//            req.getRequestDispatcher(ERROR).forward(req,resp);
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.print("accFail");
            out.flush();
            out.close();
        }
    }
}

