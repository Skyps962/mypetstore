package org.csu.mypetstore.web.Filter;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.DBUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-17 01:14
 **/
public class LogFilter implements Filter {

    private static final String INSRET_LOG = "INSERT INTO log (username,action,date) VALUES (?,?,?)";
    Account account;
    Date date = new Date();


    private int count=0;
    @Override
    public void init(FilterConfig arg0) throws ServletException {
//        System.out.println("LogFilter初始化了...");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
//        System.out.println("进入LogFilter的doFilter方法了...");
        try {
            chain.doFilter(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        count++;
        HttpServletRequest request = (HttpServletRequest)req;
        String requestURI = request.getRequestURI();
        List<String> logList = new ArrayList<String>();



        logList.add(requestURI);


//        System.out.println("日志过滤器总共过滤了"+count+"条访问记录");
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//        HttpSession session = request.getSession();
//        account = (Account) session.getAttribute("account");
            Iterator<String> it = logList.iterator();
            while(it.hasNext()){
                try {
                    Connection connection = DBUtil.getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(INSRET_LOG);
                    if(account == null){
                        preparedStatement.setString(1,"Visitor");
                    }else{
                        preparedStatement.setString(1,account.getUsername());
                    }
                    preparedStatement.setString(2,it.next());
                    preparedStatement.setString(3,formatter.format(date));
                    preparedStatement.execute();
                    DBUtil.closeStatement(preparedStatement);
                    DBUtil.closeConnection(connection);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        for(String uri:logList){
            System.out.println(uri);
        }
//        System.out.println("将要离开LogFilter的doFilter......");
    }

    @Override
    public void destroy() {
//        System.out.println("LogFilter销毁了...");
    }

}
