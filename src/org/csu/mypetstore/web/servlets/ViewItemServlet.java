package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
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
 * create: 2020-11-15 15:36
 **/
public class ViewItemServlet extends HttpServlet {

    private String itemId;
    private static final String VIEW_ITEM = "/WEB-INF/jsp/catalog/Item.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        itemId = req.getParameter("itemId");
        CatalogService service = new CatalogService();
        Item item = service.getItem(itemId);

        HttpSession session = req.getSession();
        session.setAttribute("item",item);

        req.getRequestDispatcher(VIEW_ITEM).forward(req,resp);
    }
}
