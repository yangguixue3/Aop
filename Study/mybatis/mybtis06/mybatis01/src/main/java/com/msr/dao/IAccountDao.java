package com.msr.dao;

import com.msr.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface IAccountDao {

    /**
     * 查询所有的账户,同时获取账户所属用户的信息
     * @return
     */
    @Results(id = "accountMap" , value = {
        @Result(id = true,column = "id" ,property = "accountId"),
        @Result(column = "uid" ,property = "userId"),
        @Result(column = "money" ,property = "money"),
        @Result(property = "user",column = "uid",one = @One(
                select = "com.msr.dao.IUserDao.findUserById",
                fetchType = FetchType.EAGER
        ))
    })
    @Select("select * from account ")
    List<Account> findAll();


    @ResultMap("accountMap")
    @Select("select * from account where uid = ${uid} ")
    Account findAccountById(Integer uid);
}
