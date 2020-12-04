package com.msr.factory;

import com.msr.service.IAccountService;
import com.msr.service.impl.AccountServiceImpl;
import com.msr.unti.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理类，代理事务管理
 */
public class ProxyFactory {
    //被代理类
    private IAccountService accountService;
    //事务
    private TransactionManager transactionManager;
    //set注入
    public void setAccountService(AccountServiceImpl accountService) {
        this.accountService = accountService;
    }
    // set注入
    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 生成accountService的代理 对象:proxyIAccountService
     */
    public IAccountService getAccountService(){
        IAccountService proxyIAccountService= (IAccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 通过事务，执行任务的步骤
                        Object Returnobject = null;
                        // 1.开启事务
                        transactionManager.beginTransaction();
                        // 2.执行业务操作
                        try {
                            Returnobject = method.invoke(accountService,args);

                            // 3.提交事务
                            transactionManager.commit();
                            // 4.返回结果
                        } catch (Exception e) {
                            System.out.println("异常，回滚");
                            // 5.异常，回滚
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        }finally {
                            // 6.释放资源
                            transactionManager.release();
                        }
                        System.out.println("调用代理事务");
                        return Returnobject;
                    }
                }
        );

        return proxyIAccountService;
    }
}
