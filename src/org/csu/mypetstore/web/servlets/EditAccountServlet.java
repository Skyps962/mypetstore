package org.csu.mypetstore.web.servlets;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-16 08:53
 **/
public class EditAccountServlet extends HttpServlet {

    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String ERROR = "/WEB-INF/jsp/common/Error.jsp";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountService service = new AccountService();
        HttpSession session = req.getSession();
        if(req.getParameter("password").equals(req.getParameter("repeatedPassword"))){
            Account account = (Account) session.getAttribute("account");
            account.setUsername(account.getUsername());
            account.setPassword(req.getParameter("password"));
            account.setFirstName(req.getParameter("account.firstName"));
            account.setLastName(req.getParameter("account.lastName"));
            account.setEmail(req.getParameter("account.email"));
            account.setPhone(req.getParameter("account.phone"));
            account.setAddress1(req.getParameter("account.address1"));
            account.setAddress2(req.getParameter("account.address2"));
            account.setState(req.getParameter("account.state"));
            account.setZip(req.getParameter("account.zip"));
            account.setCountry(req.getParameter("account.country"));
            account.setCity(req.getParameter("account.city"));
            account.setState(req.getParameter("account.state"));
            account.setLanguagePreference(req.getParameter("account.languagePreference"));
            account.setFavouriteCategoryId(req.getParameter("account.favouriteCategory"));
            if(Objects.equals(req.getParameter("account.listOption"), "1"))
                account.setListOption(true);
            else
                account.setListOption(false);

            if(Objects.equals(req.getParameter("account.bannerOption"), "2"))
                account.setBannerOption(true);
            else
                account.setBannerOption(false);
            if(Objects.equals(account.getUsername(), "") || Objects.equals(account.getPassword(), "") || Objects.equals(account.getEmail(), "")){
                session.setAttribute("message","请至少输入用户名密码邮箱这三项信息");
                req.getRequestDispatcher(ERROR).forward(req,resp);
            }
            else{
                service.updateAccount(account);
                req.getRequestDispatcher(MAIN).forward(req,resp);
            }
        }
        else{
            session.setAttribute("message","两次密码不一致");
            req.getRequestDispatcher(ERROR).forward(req,resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
