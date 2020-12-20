package com.msr.dao;

import com.msr.domain.User;
import com.msr.pojo.QueryVO;

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
     * 模糊查询 : 名字中含有王字的人
     * @return
     */
    List<User> findAllByName(String username);

    /**
     * POJO : 查询
     * @return
     */
    List<User> findAllByQueryVO(QueryVO queryVO);

    /**
     * 根据传入的参数条件进行查询
     * @return
     */
    List<User> findAllByCondition(User user);


    /**
     * 多个ids的查询
     * @return
     */
    List<User> findAllByIds(QueryVO queryVO);

}
