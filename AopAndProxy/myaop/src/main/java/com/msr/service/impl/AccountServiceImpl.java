package com.msr.service.impl;

import com.msr.dao.IAccountDao;
import com.msr.domain.Account;
import com.msr.service.IAccountService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 辉
 * @create 2020-10-30 9:20
 * @desc
 */

public class AccountServiceImpl implements IAccountService {

    //dao层
    private IAccountDao accountDao ;

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }


    // 通过事务，执行任务的步骤
    // 1.开启事务
    // 2.执行业务操作
    // 3.提交事务
    // 4.返回结果
    // 5.异常，回滚
    // 6.释放资源

    @Override
    public List<Account> queryAll() throws SQLException {
            List<Account> accounts =accountDao.queryAll();
            return accounts;

    }

    @Override
    public Account queryAccountById(Integer id) {
        return accountDao.queryAccountById(id);
    }

    @Override
    public void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }

    @Override
    public void updateAccountById(Account account) throws SQLException {
        accountDao.updateAccountById(account);
    }

    @Override
    public void deleteAccountById(Integer id) {
        accountDao.deleteAccountById(id);
    }

    @Override
    public int queryTotalCount() {
        return accountDao.queryTotalCount();
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) throws SQLException {



            // 2.1.根据用户名查询转出账户
            Account sourceAccount = accountDao.queryAccountByName(sourceName);
            // 2.2根据用户名查询转入账户
            Account targetAccount = accountDao.queryAccountByName(targetName);
            // 2.3.转出账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney() - money);
            // 2.4.转入账户加钱
            targetAccount.setMoney(targetAccount.getMoney() + money);
            // 2.5.更新转出账户信息
            accountDao.updateAccountById(sourceAccount);
            //异常
            int i = 10/0;
            // 6.更新转入账户信息
            accountDao.updateAccountById(targetAccount);

    }
}
