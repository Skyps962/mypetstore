package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.List;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-15 16:00
 **/
public class SearchProductServlet extends HttpServlet {

    private String keyword;
    private static final String VIEW_SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        keyword = req.getParameter("keyword");
        CatalogService service = new CatalogService();
        List<Product> products = service.searchProductList(keyword);

        HttpSession session = req.getSession();
        session.setAttribute("productList",products);

        req.getRequestDispatcher(VIEW_SEARCH_PRODUCTS).forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
