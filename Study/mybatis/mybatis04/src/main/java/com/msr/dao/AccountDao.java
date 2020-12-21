package com.msr.dao;

import com.msr.domain.Account;

import java.util.List;

/**
 * @author 辉
 * @create 2020-12-18 10:38
 * @desc
 */
public interface AccountDao {

    /**
     * 查询账户的同时,获取账户对应的用户信息
     * @return
     */
    List<Account> findAll();


    /**
     * 通过用户的uid来查询账户
     * @param uid
     * @return
     */
    Account findByUid(Integer uid);
}
