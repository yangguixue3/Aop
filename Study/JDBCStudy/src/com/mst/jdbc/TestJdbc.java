package com.mst.jdbc;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TestJdbc {
    private static String driver ;
    private static String url ;
    private static String username ;
    private static String password ;

    static {
        // 1加载配置文件
        // 1.1创建配置文件的内存对象
        Properties properties = new Properties();
        // 1.2利用IO流从硬盘读取文件内容
        InputStream  inputStream= TestJdbc.class.getClassLoader().getResourceAsStream("jdbc.properties");


        // 2.注册并加载驱动
        try {
            // 2.1将内存对象properties与inputStream关联起来
            properties.load(inputStream);
            // 2.2读取配置文件数据
            driver = properties.getProperty("jdbc.driver");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            Class.forName(driver);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJdbc() {
        // 1.导入驱动,并关联
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;// executeQuery() : 只用于查询    executeUpdate() : 只适用于增删改查
        try {
            // 3.获取数据库链接
            connection = DriverManager.getConnection(url, username, password);
            // 4.获取sql语句执行对象
            statement = connection.createStatement();
            // 5.创建sql语句
            String sql = "select * from account ";
            // 6.执行sql语句
            resultSet = statement.executeQuery(sql);
            // 7.处理结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int money = resultSet.getInt("money");

                System.out.println(id + " : " + name + " : " + money ) ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            // 8.释放资源
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
