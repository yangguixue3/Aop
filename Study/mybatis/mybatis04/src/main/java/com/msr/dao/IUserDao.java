package com.msr.dao;

import com.msr.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户,同时携带用户名下的账户信息
     * @return
     */
    List<User> findAll();


    /**
     * 通过用户id来查寻用户信息
     * @param uid
     * @return
     */
    User findById(Integer uid);
}
