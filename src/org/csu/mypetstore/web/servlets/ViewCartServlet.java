package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Cart;

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
 * create: 2020-11-15 18:05
 **/
public class ViewCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null)
        {
            cart = new Cart();
            session.setAttribute("cart",cart);
        }

        req.getRequestDispatcher(VIEW_CART).forward(req,resp);
    }
}
