package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Sequence;
import org.csu.mypetstore.persistence.DBUtil;
import org.csu.mypetstore.persistence.SequenceDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-16 17:29
 **/
public class SequenceDAOImpl implements SequenceDAO {

    private static final String GET_SEQUENCE = "SELECT name, nextid\n" +
            "    FROM SEQUENCE\n" +
            "    WHERE NAME = ?";

    private static final String UPDATE_SEQUENCE = "UPDATE SEQUENCE\n" +
            "    SET NEXTID = ?\n" +
            "    WHERE NAME = ?";


    @Override
    public Sequence getSequence(Sequence sequence) {
        Sequence sequence1 = new Sequence();
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_SEQUENCE);
            preparedStatement.setString(1,sequence.getName());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                sequence1.setName(resultSet.getString(1));
                sequence1.setNextId(resultSet.getInt(2));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return sequence1;
    }

    @Override
    public void updateSequence(Sequence sequence) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEQUENCE);
            preparedStatement.setInt(1,sequence.getNextId());
            preparedStatement.setString(2,sequence.getName());
            preparedStatement.execute();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
