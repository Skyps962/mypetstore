package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-15 18:37
 **/
public class RemoveItemFromCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";
    private String workingItemId;
    private Cart cart;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workingItemId = req.getParameter("workingItemId");

        HttpSession session = req.getSession();
        cart = (Cart) session.getAttribute("cart");

        Item item = cart.removeItemById(workingItemId);

        if(item == null){
            session.setAttribute("message","Attempted to remove null cartItem from Cart.");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }else{
            req.getRequestDispatcher(VIEW_CART).forward(req,resp);
        }
    }
}
