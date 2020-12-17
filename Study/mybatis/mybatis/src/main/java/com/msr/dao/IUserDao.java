package com.msr.dao;

import com.msr.domain.User;

import java.util.List;

public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 通过编号查询用户详情
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 新增用户
     * @param user
     */
    void saveUser(User user) ;


    /**
     * 更新用户信息
     * @param user
     */
    void updateUserById(User user) ;


    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUserById(Integer id) ;


    /**
     * 模糊查询 : 名字中含有王字的人
     * @return
     */
    List<User> findAllByName(String username);



    /**
     * 聚合函数 : count()
     * @return
     */
   int findAllTotal(String username);
}
