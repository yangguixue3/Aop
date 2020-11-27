package com.msr.service;

import com.msr.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * queryAll
     */
    List<Account> queryAll();

    /**
     * insert
     */
    void insert(Account account);

}
