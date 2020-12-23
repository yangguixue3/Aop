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
     * 新增
     * @return
     */
    @ResultMap(value = "userMap")
    @Insert("insert into user values(null ,#{userName} ,#{userBirthday} ,#{userSex} ,#{userAddress})  ")
    void addUser(User user);
    /**
     * 修改用户
     * @return
     */
    @ResultMap("userMap")
    @Update("update user set username = #{userName} , sex = #{userSex} , birthday = #{userBirthday} , address = #{userAddress} where id = #{userId} ")
    void updateUserById(User user);
    /**
     * 删除用户
     * @return
     */
    @Delete("delete from user where id = #{uid} ")
    void deleteUserById(Integer uid);

    /**
     * 通过用户id来查寻用户信息
     * @param uid
     * @return
     */
    @ResultMap("userMap")
    @Select("select * from user where id = #{uid}")
    User findUserById(Integer uid);
}
