package com.msr.dao;

import com.msr.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     *  queryAll
     */
    List<Account> queryAll();

    /**
     *  insert
     */
    void insert(Account account);

}
