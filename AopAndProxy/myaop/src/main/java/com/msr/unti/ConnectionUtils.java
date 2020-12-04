package com.msr.unti;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接工具类
 * 获取或移除 当前线程上的 数据库链接
 */
public class ConnectionUtils {
    // ThreadLocal 当前线程
    private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    // DataSource 数据源
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程的数据库链接
     * @return
     */
    public Connection getThreadLocalConnection(){
        // 1.从线程上获取数据连接
        Connection connection = connectionThreadLocal.get();
        // 2.判断连接是否存在
        try {
            if (connection == null) {
                // 3.数据连接不存在 从数据源上获取，并存入当前线程
                connection = dataSource.getConnection();
                //把从数据源上获取的连接，存入线程
                connectionThreadLocal.set(connection);
                return connection;
            }

        }catch (Exception e  ){
            throw new RuntimeException("从数据源上获取链接失败");
        }
        // 4.返回当前线程上的连接
        return connection;
    }

    /**
     * 数据库链接与线程解绑,及移除之前设置的 set(connection)
     */
    public void removeConnection() {
        connectionThreadLocal.remove();
    }
}
