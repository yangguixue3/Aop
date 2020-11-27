package com.msr.service.Impl;


import com.msr.domain.Account;
import com.msr.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> queryAll() {
        System.out.println("service层:执行了查询所有账户功能...");
        return null;
    }

    @Override
    public void insert(Account account) {
        System.out.println("service层:执行了新增账户功能...");

    }
}