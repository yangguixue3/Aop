package com.msr.service.impl;

import com.msr.service.IAccountService;


public class AccountServiceImpl implements IAccountService {

    @Override
    public void insertAccount() {
        System.out.println("实现了c插入功能!!");
    }

    @Override
    public void updateAccount(int id) {
        System.out.println("实现了更新的功能");
    }

    @Override
    public int deleteAccount() {
        System.out.println("实现了删除的功能.............");
        return 0;
    }
}
