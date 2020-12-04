package com.msr.unti;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 事务相关工具类
 *  开启
 *  提交
 *  回滚
 *  资源释放
 */

@Component("transactionManagerAopAround")
@Aspect//表明 是 切面类
public class TransactionManagerAopAround {
    //获取链接
    private ConnectionUtils connectionUtils;
    // set 注入
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     *  开启事务
     */
    public void beginTransaction(){
        // 获取链接，改为手动提交
        try {
            connectionUtils.getThreadLocalConnection().setAutoCommit(false);

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }

    }

    /**
     *  回滚事务
     */
    public void rollback(){
        try {
            connectionUtils.getThreadLocalConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *  提交事务
     */
    public void commit(){
        try {
            connectionUtils.getThreadLocalConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     *  释放连接
     */
    public void release(){
        // 释放连接，把数据连接归还到数据库连接池中。不是把连接关掉了。
        try {
            //将事务从新设为 自动提交
            connectionUtils.getThreadLocalConnection().setAutoCommit(true);
            //释放资源
            connectionUtils.getThreadLocalConnection().close();
            //链接与当前线程解绑
            connectionUtils.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * 切入点 注解AOP 必须
     */
    @Pointcut("execution(* com.msr.service.impl.AccountServiceAopAroundImpl.*(..)))")
    public void myPiontCut(){

    }

    /**
     * 环绕通知 Aop
     *
     *  问题 : 配置环绕通知后,切入点方法没有执行,仅执行了通知方法
     *   原因;配置　没有有切入点函数的明显调用
     *   解决 spring框架中接口 : ProceedingJoinPoint 中的函数   proceed()
     * @param proceedingJoinPoint
     */
    @Around("myPiontCut()")//引用切入点
    public void aroundAopPrintCut(ProceedingJoinPoint proceedingJoinPoint ){

        try {
            // 前置通知 开启事务
            beginTransaction();
            // 获取切入点方法的参数
            Object[] args = proceedingJoinPoint.getArgs();
            // 显式调用切入点函数
            proceedingJoinPoint.proceed();
            // 后置通知 提交事务
            commit();

        } catch (Throwable throwable) {
            //异常通知 回滚事务
            rollback();
            throwable.printStackTrace();
        } finally {
            // 最终通知
            release();
        }


    }
}
