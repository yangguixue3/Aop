package com.msr.service;

import com.msr.domain.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {

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

    /**
     * 模拟转账
     * @param sourceName 转出
     * @param targetName 转入账户
     * @param money 金额
     */
    void transfer(String sourceName,String targetName,float money) throws SQLException;
}
