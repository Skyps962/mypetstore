package org.csu.mypetstore.service;

import org.csu.mypetstore.domain.Account;
import org.csu.mypetstore.persistence.AccountDAO;
import org.csu.mypetstore.persistence.impl.AccountDAOImpl;

/**
 * program: mypetstore
 * <p>
 * description:
 * <p>
 * author: yps
 * <p>
 * create: 2020-11-15 19:50
 **/
public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAOImpl();
    }

    public Account getAccount(String username) {
        return accountDAO.getAccountByUsername(username);
    }
    //已完成

    public Account getAccount(String username, String password) {
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        return accountDAO.getAccountByUsernameAndPassword(account);
    }


    public void insertAccount(Account account) {
        accountDAO.insertAccount(account);
        accountDAO.insertProfile(account);
        accountDAO.insertSignOn(account);
    }

    public void updateAccount(Account account) {
        accountDAO.updateAccount(account);
        accountDAO.updateProfile(account);

        if (account.getPassword() != null && account.getPassword().length() > 0) {
            accountDAO.updateSignOn(account);
        }
    }
}
