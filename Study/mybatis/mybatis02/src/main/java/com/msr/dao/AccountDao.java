package com.msr.dao;

import com.msr.domain.Account;

import java.util.List;

/**
 *
 */
public interface AccountDao {

    /**
     * 查询账户的同时,获取账户对应的用户信息
     * @return
     */
    List<Account> findAll();
}
