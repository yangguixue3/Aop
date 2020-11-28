package com.msr.dao.impl;

import com.msr.dao.IAccountDao;
import com.msr.domain.Account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 *
 */
@Repository("accountDao")
public class AccountDaoImpl  implements IAccountDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account queryAccountByName(String accountName) throws SQLException {

            List<Account> accountList=jdbcTemplate.query("select * from account where name = ? ", new BeanPropertyRowMapper<>(Account.class),accountName);
            // null                   jdbcTemplate.query("select * from account where name = ? ", new BeanPropertyRowMapper<>(Account.class), accountName);
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

        List<Account> accountList = jdbcTemplate.query("select * from account ", new BeanPropertyRowMapper<>(Account.class));
        return accountList;
    }

    @Override
    public Account queryAccountById(Integer id) {
        List<Account> accountList = jdbcTemplate.query("select * from account where id = ? ", new BeanPropertyRowMapper<>(Account.class), id);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public void insertAccount(Account account) {
        jdbcTemplate.update("insert into account(name,money) values(?,?) ", account.getName(),account.getMoney());
    }

    @Override
    public void updateAccountById( Account account) throws SQLException {

        jdbcTemplate.update("update account set name = ? , money = ? where id = ?  ", account.getName(),account.getMoney(),account.getId());

    }

    @Override
    public void deleteAccountById(Integer id) {
        jdbcTemplate.update("delete from account where id = ?  ", id);
    }

    @Override
    public int queryTotalCount() {
        return jdbcTemplate.queryForObject("select count(*) from account ",Integer.class);
    }
}