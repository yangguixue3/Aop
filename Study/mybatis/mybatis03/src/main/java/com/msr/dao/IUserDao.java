package com.msr.dao;

import com.msr.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户,同时携带用户所扮演的角色信息
     * @return
     */
    List<User> findAll();

}
