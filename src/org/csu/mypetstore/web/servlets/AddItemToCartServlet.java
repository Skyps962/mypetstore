package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.service.CatalogService;

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
 * create: 2020-11-15 17:20
 **/
public class AddItemToCartServlet extends HttpServlet {

    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private String workingItemId;
    private Cart cart;
    private CatalogService service;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        workingItemId = req.getParameter("workingItemId");

        HttpSession session = req.getSession();
        cart = (Cart)session.getAttribute("cart");

        if(cart == null){
            cart = new Cart();
        }

        if(cart.containsItemId(workingItemId)){
            cart.incrementQuantityByItemId(workingItemId);
        }
        else{
            service = new CatalogService();
            boolean isInStock = service.isItemInStock(workingItemId);
            Item item = service.getItem(workingItemId);
            cart.addItem(item,isInStock);
        }
        session.setAttribute("cart",cart);
        req.getRequestDispatcher(VIEW_CART).forward(req,resp);
    }
}
