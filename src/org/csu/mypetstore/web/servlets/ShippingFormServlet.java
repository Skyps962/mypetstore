package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Order;

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
 * create: 2020-11-16 17:50
 **/
public class ShippingFormServlet extends HttpServlet {

    private static final String SHIPPING_FROM = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private static final String CONFIRM_FROM = "/WEB-INF/jsp/order/ConfirmOrder.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        order.setCardType(req.getParameter("order.cardType"));
        order.setCreditCard(req.getParameter("order.creditCard"));
        order.setExpiryDate(req.getParameter("order.expiryDate"));
        order.setBillToFirstName(req.getParameter("order.billToFirstName"));
        order.setBillToLastName(req.getParameter("order.billToLastName"));
        order.setBillAddress1(req.getParameter("order.billAddress1"));
        order.setBillAddress2(req.getParameter("order.billAddress2"));
        order.setBillCity(req.getParameter("order.billCity"));
        order.setBillState(req.getParameter("order.billState"));
        order.setBillZip(req.getParameter("order.billZip"));
        order.setBillCountry(req.getParameter("order.billCountry"));
        HttpSession session = req.getSession();
        session.setAttribute("order",order);
        if(req.getParameter("shippingAddressRequired")==null){
            req.getRequestDispatcher(CONFIRM_FROM).forward(req,resp);
        }else{

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
