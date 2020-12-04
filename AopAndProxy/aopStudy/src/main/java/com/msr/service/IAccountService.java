package com.msr.service;

/**
 * 模拟业务层
 */
public interface IAccountService {
    /**
     * 添加账户
     */
    void insertAccount() ;

    /**
     * 根据id更新账户
     * @param id
     */
    void updateAccount(int id) ;

    /**
     * 删除账户
     * @return
     */
    int deleteAccount() ;
}
