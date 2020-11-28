package com.msr.dao;

import com.msr.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao {

    /**
     * 根据账户名称查询账户
     * @param accountName
     * @return 1.null  2.多个账户。抛异常 3.结果正常，为一个。返回该账户
     */
    Account queryAccountByName( String accountName) throws SQLException;

    /**
     * 查询所有账户
     * @return
     */
    List<Account> queryAll() throws SQLException;

    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account queryAccountById(Integer id);

    /**
     * 新增账户
     * @param account
     */
    void insertAccount(Account account);

    /**
     * 通过id来更新账户信息
     * @param account
     */
    void updateAccountById(Account account) throws SQLException;

    /**
     * 根据id删除账户
     * @param id
     */
    void deleteAccountById(Integer id);

    /**
     * 查询总数
     * @return
     */
    int queryTotalCount();
}
