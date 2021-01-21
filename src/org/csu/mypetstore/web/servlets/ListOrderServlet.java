package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.OrderService;

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
 * create: 2020-11-16 21:15
 **/
public class ListOrderServlet extends HttpServlet {

    private static final String VIEW_SIGN_ON = "/WEB-INF/jsp/order/ListOrders.jsp";
    private String username;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService service = new OrderService();
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        username = account.getUsername();
        session.setAttribute("orderList",service.getOrdersByUsername(username));
        req.getRequestDispatcher(VIEW_SIGN_ON).forward(req,resp);
    }
}
