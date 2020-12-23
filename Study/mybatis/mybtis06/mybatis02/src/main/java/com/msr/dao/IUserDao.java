package com.msr.dao;

import com.msr.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
@CacheNamespace(blocking = true)
public interface IUserDao {

    /**
     * 查询所有用户
     * @return
     */
    @Results(id="userMap",value = {
            @Result(id = true,column = "id" ,property = "userId"),
            @Result(column = "username" , property = "userName"),
            @Result(column = "birthday" , property = "userBirthday"),
            @Result(column = "sex" , property = "userSex"),
            @Result(column = "address" , property = "userAddress"),
            @Result(property = "accounts",column = "id", many = @Many(
                    select = "com.msr.dao.IAccountDao.findAccountById",
                    fetchType = FetchType.LAZY
            ))
    })
    @Select("select * from user ")
    List<User> findAll();

    /**
     * 通过用户id来查寻用户信息
     * @param uid
     * @return
     */
    @ResultMap("userMap")
    @Select("select * from user where id = #{uid}")
    User findUserById(Integer uid);
}
