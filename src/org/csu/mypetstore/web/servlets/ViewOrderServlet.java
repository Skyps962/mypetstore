package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

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
 * create: 2020-11-16 21:42
 **/
public class ViewOrderServlet extends HttpServlet {

    private String orderId;
    private static final String VIEW_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderId = req.getParameter("orderId");
        OrderService service = new OrderService();
        Order order = service.getOrder(Integer.parseInt(orderId));
        req.getSession().setAttribute("order",order);
        req.getRequestDispatcher(VIEW_ORDER).forward(req,resp);
    }
}
