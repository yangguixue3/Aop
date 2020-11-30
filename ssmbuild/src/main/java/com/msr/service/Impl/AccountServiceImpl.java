package com.msr.service.Impl;


import com.msr.domain.Account;
import com.msr.mapper.AccountMapper;
import com.msr.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;
    @Override
    public List<Account> queryAll() {
        System.out.println("service层:执行了查询所有账户功能...");
        List<Account> accounts = accountMapper.queryAll();
        return accounts;
    }

    @Override
    public void insert(Account account) {
        accountMapper.insert(account);
        System.out.println("service层:执行了新增账户功能...");

    }
}