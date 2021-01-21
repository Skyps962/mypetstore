package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Item;
import org.csu.mypetstore.domain.Product;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.ItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-15 13:48
 **/
public class  ItemDAOImpl implements ItemDAO {

    private static final String GET_ITEMLIST_BY_PRODUCT = "SELECT\n" +
            "      I.ITEMID,\n" +
            "      LISTPRICE,\n" +
            "      UNITCOST,\n" +
            "      SUPPLIER AS supplierId,\n" +
            "      I.PRODUCTID AS \"product.productId\",\n" +
            "      NAME AS \"product.name\",\n" +
            "      DESCN AS \"product.description\",\n" +
            "      CATEGORY AS \"product.categoryId\",\n" +
            "      STATUS,\n" +
            "      ATTR1 AS attribute1,\n" +
            "      ATTR2 AS attribute2,\n" +
            "      ATTR3 AS attribute3,\n" +
            "      ATTR4 AS attribute4,\n" +
            "      ATTR5 AS attribute5\n" +
            "    FROM ITEM I, PRODUCT P\n" +
            "    WHERE P.PRODUCTID = I.PRODUCTID\n" +
            "    AND I.PRODUCTID = ?";

    private static final String GET_ITEM = "select\n" +
            "      I.ITEMID,\n" +
            "      LISTPRICE,\n" +
            "      UNITCOST,\n" +
            "      SUPPLIER AS supplierId,\n" +
            "      I.PRODUCTID AS \"product.productId\",\n" +
            "      NAME AS \"product.name\",\n" +
            "      DESCN AS \"product.description\",\n" +
            "      CATEGORY AS \"product.categoryId\",\n" +
            "      STATUS,\n" +
            "      ATTR1 AS attribute1,\n" +
            "      ATTR2 AS attribute2,\n" +
            "      ATTR3 AS attribute3,\n" +
            "      ATTR4 AS attribute4,\n" +
            "      ATTR5 AS attribute5,\n" +
            "      QTY AS quantity\n" +
            "    from ITEM I, INVENTORY V, PRODUCT P\n" +
            "    where P.PRODUCTID = I.PRODUCTID\n" +
            "      and I.ITEMID = V.ITEMID\n" +
            "      and I.ITEMID = ?";

    private static final String UPDATE_INVENTORY_QUANTITY = "UPDATE INVENTORY SET\n" +
            "      QTY = QTY - ?\n" +
            "    WHERE ITEMID = ?";

    private static final String GET_INVENTORY_QUANTITY = "SELECT QTY AS value\n" +
            "    FROM INVENTORY\n" +
            "    WHERE ITEMID = ?";



    @Override
    public void updateInventoryQuantity(Map<String, Object> param) {
//        try{
//            Connection connection = DBUtil.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_INVENTORY_QUANTITY);
//            String itemId = param.keySet().iterator().next();
//            Integer increment = (Integer) param.get(itemId);
//            preparedStatement.setInt(1, increment);
//            preparedStatement.setString(2,itemId);
//            DBUtil.closeStatement(preparedStatement);
//            DBUtil.closeConnection(connection);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }

    @Override
    public int getInventoryQuantity(String itemId) {
        int result = -1;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_INVENTORY_QUANTITY);
            preparedStatement.setString(1,itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                result = resultSet.getInt(1);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> getItemListByProduct(String productId) {
        List<Item> items = new ArrayList<Item>();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEMLIST_BY_PRODUCT);
            preparedStatement.setString(1,productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Item item = new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product = new Product();
                product.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));
                items.add(item);
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item getItem(String itemId) {
        Item item = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM);
            preparedStatement.setString(1,itemId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                item = new Item();
                item.setItemId(resultSet.getString(1));
                item.setListPrice(resultSet.getBigDecimal(2));
                item.setUnitCost(resultSet.getBigDecimal(3));
                item.setSupplierId(resultSet.getInt(4));
                Product product = new Product();
                product.setProductId(resultSet.getString(5));
                product.setName(resultSet.getString(6));
                product.setDescription(resultSet.getString(7));
                product.setCategoryId(resultSet.getString(8));
                item.setProduct(product);
                item.setStatus(resultSet.getString(9));
                item.setAttribute1(resultSet.getString(10));
                item.setAttribute2(resultSet.getString(11));
                item.setAttribute3(resultSet.getString(12));
                item.setAttribute4(resultSet.getString(13));
                item.setAttribute5(resultSet.getString(14));
                item.setQuantity(resultSet.getInt(15));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return item;
    }
}
