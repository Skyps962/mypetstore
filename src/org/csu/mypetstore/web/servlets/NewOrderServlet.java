package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Cart;
import org.csu.mypetstore.domain.Order;
import org.csu.mypetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-16 18:44
 **/
public class NewOrderServlet extends HttpServlet {

    private static final String MAIN = "/WEB-INF/jsp/cart/Checkout.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("account")==null){
            req.getSession().setAttribute("message","请先登录!");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }
        else{
            OrderService service = new OrderService();
            Order order = (Order) req.getSession().getAttribute("order");
            Account account = (Account)req.getSession().getAttribute("account");
            Cart cart = (Cart)req.getSession().getAttribute("cart");

            order.initOrder(account,cart);

            service.insertOrder(order);
            req.getRequestDispatcher(MAIN).forward(req,resp);
        }
    }
}
