package com.msr.service;

import com.msr.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;


/**
 * 目标: 启用框架事务，xml配置，启用AOP
 *      1.xml　
 *      2.　dao层 server 层
 *
 * 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
//此处加载的是配置，不是配置类
@ContextConfiguration(locations = "classpath:SpringConfig.xml")
public class IAccountServiceTest {
    @Autowired
    @Qualifier("accountService")
    private IAccountService iAccountService;

    @Test
    public void queryAll() throws SQLException {
         List<Account>  accounts= iAccountService.queryAll();
        accounts.forEach(account -> System.out.println(account));
    }

    /**
     * 动态代理 事务
     * @throws SQLException
     */
    @Test
    public void transfer() throws SQLException {
        iAccountService.transfer("aaa","bbb",100F);
    }


}
