package com.msr.dao.impl;

import com.msr.dao.IAccountDao;
import com.msr.domain.Account;
import com.msr.unti.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 辉
 * @create 2020-10-30 9:18
 * @desc
 */

public class AccountDaoImpl implements IAccountDao {


    private QueryRunner queryRunner ;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    @Override
    public Account queryAccountByName(String accountName) throws SQLException {

            List<Account> accountList=queryRunner.query(connectionUtils.getThreadLocalConnection(),"select * from account where name = ?", new BeanListHandler<>(Account.class),accountName);
            // null
            if (accountList == null || accountList.size() == 0) {
                return null;
            }
            // 多个账户
            if (accountList.size()>1) {
                throw new RuntimeException("数据异常，用户名，都多个账号 ");
            }
            //结果唯一。

            return accountList.get(0);

    }

    @Override
    public List<Account> queryAll() throws SQLException {

            return queryRunner.query(connectionUtils.getThreadLocalConnection(),"select * from account ", new BeanListHandler<>(Account.class));

    }

    @Override
    public Account queryAccountById(Integer id) {
        try {
            return queryRunner.query(connectionUtils.getThreadLocalConnection(),"select * from account where id = ? ", new BeanHandler<>(Account.class),id);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public void insertAccount(Account account) {
        try {
            queryRunner.update("insert into account(name,money) values(?,?) ", account.getName(),account.getMoney());
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public void updateAccountById( Account account) throws SQLException {

            queryRunner.update(connectionUtils.getThreadLocalConnection(),"update account set name = ? , money = ? where id = ?  ", account.getName(),account.getMoney(),account.getId());

    }

    @Override
    public void deleteAccountById(Integer id) {
        try {
            queryRunner.update("delete from account where id = ?  ", id);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public int queryTotalCount() {
        try {
            return ((Long)queryRunner.query("select count(1) from account ", new ScalarHandler<>())).intValue();
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
