package com.msr.dao;

import com.msr.domain.AccountUser;

import java.util.List;

/**
 *
 */
public interface AccountUserDao {

    /**
     * 查询账户的同时,获取账户对应的用户的姓名和地址
     * @return
     */
    List<AccountUser> findAll();
}
