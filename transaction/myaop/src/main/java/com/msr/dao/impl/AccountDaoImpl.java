package com.msr.dao.impl;

import com.msr.dao.IAccountDao;
import com.msr.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.sql.SQLException;
import java.util.List;

/**
 *JdbcDaoSupport是Spring内置的一个Dao层的基类
 */

public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {

    @Override
    public Account queryAccountByName(String accountName) throws SQLException {

            List<Account> accountList=super.getJdbcTemplate().query("select * from account where name = ? ", new BeanPropertyRowMapper<>(Account.class),accountName);
            // null                   super.getJdbcTemplate().query("select * from account where name = ? ", new BeanPropertyRowMapper<>(Account.class), accountName);
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

        List<Account> accountList = super.getJdbcTemplate().query("select * from account ", new BeanPropertyRowMapper<>(Account.class));
        return accountList;
    }

    @Override
    public Account queryAccountById(Integer id) {
        List<Account> accountList = super.getJdbcTemplate().query("select * from account where id = ? ", new BeanPropertyRowMapper<>(Account.class), id);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public void insertAccount(Account account) {
        super.getJdbcTemplate().update("insert into account(name,money) values(?,?) ", account.getName(),account.getMoney());
    }

    @Override
    public void updateAccountById( Account account) throws SQLException {

        super.getJdbcTemplate().update("update account set name = ? , money = ? where id = ?  ", account.getName(),account.getMoney(),account.getId());

    }

    @Override
    public void deleteAccountById(Integer id) {
        super.getJdbcTemplate().update("delete from account where id = ?  ", id);
    }

    @Override
    public int queryTotalCount() {
        return super.getJdbcTemplate().queryForObject("select count(*) from account ",Integer.class);
    }
}