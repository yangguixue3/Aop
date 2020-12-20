package com.msr.dao;

import com.msr.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户,同时携带用户名下的账户信息
     * @return
     */
    List<User> findAll();

}
