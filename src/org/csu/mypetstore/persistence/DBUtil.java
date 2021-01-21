package org.csu.mypetstore.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-14 22:58
 **/
public class DBUtil {
    private final static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private final static String CONNECTION_STRING = "jdbc:mysql://127.0.0.1:3306/mypetstore";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "8904652xuexi~!@";

    public static Connection getConnection() throws Exception{
        Class.forName(DRIVER_CLASS);
        Connection connection = DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
        return connection;
    }

    public static void closeConnection(Connection connection) throws Exception{
        if(connection != null){
            connection.close();
        }
    }

    public static void closeStatement(Statement statement) throws Exception{
        if(statement != null){
            statement.close();
        }
    }

    public static void closeResultSet(ResultSet resultSet) throws Exception{
        if(resultSet != null){
            resultSet.close();
        }
    }
//    public static void main(String[] args){
//        ProductDAO productDAO = new ProductDAOImpl();
//        List<Product> product;
//        product = productDAO.searchProductList("a");
//        System.out.println(product.get(7).getProductId());
//    }
}
