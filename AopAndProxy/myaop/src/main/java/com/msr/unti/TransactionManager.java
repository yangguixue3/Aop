package com.msr.unti;

import java.sql.SQLException;

/**
 * 事务相关工具类
 *  开启
 *  提交
 *  回滚
 *  资源释放
 */
public class TransactionManager {
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
}
