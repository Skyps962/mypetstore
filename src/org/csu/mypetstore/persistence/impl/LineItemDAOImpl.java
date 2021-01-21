package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.LineItem;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.LineItemDAO;

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
 * create: 2020-11-16 16:36
 **/
public class LineItemDAOImpl implements LineItemDAO {

   private static final String GET_LINE_ITEMS_BY_ORDER_ID = "SELECT\n" +
            "      ORDERID,\n" +
            "      LINENUM AS lineNumber,\n" +
            "      ITEMID,\n" +
            "      QUANTITY,\n" +
            "      UNITPRICE\n" +
            "    FROM LINEITEM\n" +
            "    WHERE ORDERID = ?";

    private static final String INSERT_LINE_ITEM = "INSERT INTO LINEITEM (ORDERID, LINENUM, ITEMID, QUANTITY, UNITPRICE)\n" +
            "    VALUES (?, ?, ?, ?, ?)";

    @Override
    public List<LineItem> getLineItemsByOrderId(int orderId) {
        List<LineItem> lineItems = new ArrayList<LineItem>();
        try{
                Connection connection = DBUtil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_LINE_ITEMS_BY_ORDER_ID);
                preparedStatement.setInt(1,orderId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    LineItem lineItem = new LineItem();
                    lineItem.setOrderId(resultSet.getInt(1));
                    lineItem.setLineNumber(resultSet.getInt(2));
                    lineItem.setItemId(resultSet.getString(3));
                    lineItem.setQuantity(resultSet.getInt(4));
                    lineItem.setUnitPrice(resultSet.getBigDecimal(5));
                    lineItems.add(lineItem);
                }
                DBUtil.closeResultSet(resultSet);
                DBUtil.closeStatement(preparedStatement);
                DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return lineItems;
    }

    @Override
    public void insertLineItem(LineItem lineItem) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LINE_ITEM);
            preparedStatement.setString(1,String.valueOf(lineItem.getOrderId()));
            preparedStatement.setString(2,String.valueOf(lineItem.getLineNumber()));
            preparedStatement.setString(3,String.valueOf(lineItem.getItemId()));
            preparedStatement.setString(4,String.valueOf(lineItem.getQuantity()));
            preparedStatement.setString(5,String.valueOf(lineItem.getUnitPrice()));
            preparedStatement.execute();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
