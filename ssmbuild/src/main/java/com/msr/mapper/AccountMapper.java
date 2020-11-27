package com.msr.mapper;

import com.msr.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountMapper {
    /**
     *  queryAll
     */
    @Select("select * from account")
    List<Account> queryAll();

    /**
     *  insert
     */
    void insert(Account account);

}
