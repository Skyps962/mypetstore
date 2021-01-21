package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-16 18:34
 **/
public class ShippingToConfirmFormServlet extends HttpServlet {

    private static final String CONFIRM_FROM = "/WEB-INF/jsp/order/ConfirmOrder.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order;
        if((Order) req.getSession().getAttribute("order")!=null)
        order = (Order) req.getSession().getAttribute("order");
        else
            order = new Order();
        order.setShipToFirstName(req.getParameter("order.shipToFirstName"));
        order.setShipToLastName(req.getParameter("order.shipToLastName"));
        order.setShipAddress1(req.getParameter("order.shipAddress1"));
        order.setShipAddress2(req.getParameter("order.shipAddress2"));
        order.setShipCity(req.getParameter("order.shipCity"));
        order.setShipState(req.getParameter("order.shipState"));
        order.setShipZip(req.getParameter("order.shipZip"));
        order.setShipCountry(req.getParameter("order.shipCountry"));
        req.setAttribute("order",order);
        req.getRequestDispatcher(CONFIRM_FROM).forward(req,resp);
    }
}
