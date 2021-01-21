package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.ProductDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-15 09:55
 **/
public class ProductDAOImpl implements ProductDAO {

    private static final String GET_PRODUCTLIST_BY_CATEGORY = "SELECT PRODUCTID,CATEGORY as categoryid,NAME,DESCN as description FROM PRODUCT WHERE CATEGORY = ?";
    private static final String GET_PRODUCT = "SELECT PRODUCTID,CATEGORY as categoryid,NAME,DESCN as description FROM PRODUCT WHERE PRODUCTID = ?";
    private static final String SEARCH_PRODUCTLIST = "SELECT PRODUCTID,CATEGORY as categoryid,NAME,DESCN as description FROM PRODUCT WHERE lower(name) like ?";

    @Override
    public List<Product> getProductListByCategory(String categoryId) {
        List<Product> products = new ArrayList<Product>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTLIST_BY_CATEGORY);
            preparedStatement.setString(1,categoryId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product = new Product();
                product.setProductId(resultSet.getString(1));
                product.setCategoryId(resultSet.getString(2));
                product.setName(resultSet.getString(3));
                product.setDescription(resultSet.getString(4));
                products.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product getProduct(String productId) {
        Product product = new Product();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT);
            preparedStatement.setString(1,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                product.setProductId(resultSet.getString(1));
                product.setCategoryId(resultSet.getString(2));
                product.setName(resultSet.getString(3));
                product.setDescription(resultSet.getString(4));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> searchProductList(String keywords) {
        List<Product> products = new ArrayList<Product>();
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_PRODUCTLIST);
            preparedStatement.setString(1, keywords);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Product product = new Product();
                product.setProductId(resultSet.getString(1));
                product.setCategoryId(resultSet.getString(2));
                product.setName(resultSet.getString(3));
                product.setDescription(resultSet.getString(4));
                products.add(product);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return products;
    }
}
