package org.csu.mypetstore.web.servlets;

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
 * create: 2020-11-16 08:05
 **/
public class ViewMyAccountServlet extends HttpServlet {

    private static final String VIEW_MY_ACCOUNT = "/WEB-INF/jsp/account/EditAccountForm.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if(session.getAttribute("account")!=null){
            req.getRequestDispatcher(VIEW_MY_ACCOUNT).forward(req,resp);
        }
        else{
            session.setAttribute("message","你还没有登录");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }


    }
}
