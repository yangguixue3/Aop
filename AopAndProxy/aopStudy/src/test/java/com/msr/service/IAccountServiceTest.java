package com.msr.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IAccountServiceTest {

    public static void main(String[] args) {
        /*
         * Spring的Aop的XML实现步骤 :
         * -. 导入AOP的依赖
         * 1.创建配置文件,约束文件 SpringConfig.xml
         * 2.配置spring的IOC,将accountService对象配置进来
         * 3.配置AOP
         */

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringConfig.xml");

        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.insertAccount();

        accountService.updateAccount(110);
        accountService.deleteAccount();
    }

}
