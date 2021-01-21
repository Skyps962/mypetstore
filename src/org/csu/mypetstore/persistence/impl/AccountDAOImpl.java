package org.csu.mypetstore.persistence.impl;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.domain.Category;
import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.persistence.DBUtil;

import javax.swing.*;
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
 * create: 2020-11-15 19:48
 **/
public class AccountDAOImpl implements AccountDAO {

    private static final String GET_ACCOUNT_BY_USERNAME = "SELECT * FROM account WHERE userid = ?";
    private static final String GET_ACCOUNT_BY_USERNAME_AND_PASSWORD = "SELECT * FROM signon WHERE username = ? AND password = ?";
    private static final String INSERT_SIGN_ON = "INSERT INTO signon (username,password) VALUES (?,?)";
    private static final String INSERT_ACCOUNT = "INSERT INTO account (userid,email,firstname,lastname,status,addr1,addr2,city,state,zip,country,phone) " +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT_PROFILE = "INSERT INTO profile (userid,langpref,favcategory,mylistopt,banneropt) VALUES (?,?,?,?,?)";
    private static final String UPDATE_ACCOUNT = "UPDATE account SET userid = ?, email = ? , firstname = ? ,lastname = ?,status = ?, addr1 = ? " +
            ", addr2 =?,city=?,state=?,zip = ?,country = ?,phone = ? WHERE userid = ?";
    private static final String UPDATE_PROFILE = "UPDATE profile SET userid = ?, langpref = ?,favcategory = ?,mylistopt = ?,banneropt = ? WHERE userid = ?";
    private static final String UPDATE_SIGNON = "UPDATE signon SET username = ? ,password = ? WHERE username = ?";




    @Override
    public Account getAccountByUsername(String username) {
        Account account = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                account = new Account();
                account.setUsername(resultSet.getString(1));
                account.setEmail(resultSet.getString(2));
                account.setFirstName(resultSet.getString(3));
                account.setLastName(resultSet.getString(4));
                account.setStatus(resultSet.getString(5));
                account.setAddress1(resultSet.getString(6));
                account.setAddress2(resultSet.getString(7));
                account.setCity(resultSet.getString(8));
                account.setState(resultSet.getString(9));
                account.setZip(resultSet.getString(10));
                account.setCountry(resultSet.getString(11));
                account.setPhone(resultSet.getString(12));
            }
            DBUtil.closeResultSet(resultSet);
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) {
        String username = null;
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_USERNAME_AND_PASSWORD);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                username = resultSet.getString(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        Account account1 = getAccountByUsername(username);
        return account1;
    }

    @Override
    public void insertAccount(Account account) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACCOUNT);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getEmail());
            preparedStatement.setString(3,account.getFirstName());
            preparedStatement.setString(4,account.getLastName());
            preparedStatement.setString(5,account.getStatus());
            preparedStatement.setString(6,account.getAddress1());
            preparedStatement.setString(7,account.getAddress2());
            preparedStatement.setString(8,account.getCity());
            preparedStatement.setString(9,account.getState());
            preparedStatement.setString(10,account.getZip());
            preparedStatement.setString(11,account.getCountry());
            preparedStatement.setString(12,account.getPhone());
            preparedStatement.execute();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertProfile(Account account) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PROFILE);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getLanguagePreference());
            preparedStatement.setString(3,account.getFavouriteCategoryId());
            if(account.isListOption())
                preparedStatement.setString(4,"1");
            else
                preparedStatement.setString(4,"0");
            if(account.isBannerOption())
                preparedStatement.setString(5,"1");
            else
                preparedStatement.setString(5,"0");
            preparedStatement.execute();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void insertSignOn(Account account) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SIGN_ON);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.execute();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACCOUNT);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getEmail());
            preparedStatement.setString(3,account.getFirstName());
            preparedStatement.setString(4,account.getLastName());
            preparedStatement.setString(5,account.getStatus());
            preparedStatement.setString(6,account.getAddress1());
            preparedStatement.setString(7,account.getAddress2());
            preparedStatement.setString(8,account.getCity());
            preparedStatement.setString(9,account.getState());
            preparedStatement.setString(10,account.getZip());
            preparedStatement.setString(11,account.getCountry());
            preparedStatement.setString(12,account.getPhone());
            preparedStatement.setString(13,account.getUsername());
            preparedStatement.execute();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateProfile(Account account) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PROFILE);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getLanguagePreference());
            preparedStatement.setString(3,account.getFavouriteCategoryId());
            if(account.isListOption())
                preparedStatement.setString(4,"1");
            else
                preparedStatement.setString(4,"0");
            if(account.isBannerOption())
                preparedStatement.setString(5,"1");
            else
                preparedStatement.setString(5,"0");
            preparedStatement.setString(6,account.getUsername());
            preparedStatement.execute();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateSignOn(Account account) {
        try{
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SIGNON);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            preparedStatement.setString(3,account.getUsername());
            preparedStatement.execute();
            DBUtil.closeStatement(preparedStatement);
            DBUtil.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
