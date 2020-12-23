package com.msr.dao;

import com.msr.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class Test02 {

    private InputStream inputStream ;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        // 1.加载配置文件
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SQLSessionFactory工厂
        // 构建者模型
        builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
        // 3.获取SQLSession的对象
        sqlSession = factory.openSession();
    }
    @After
    public void destroy() throws IOException {
        // 事务提交
        sqlSession.commit();
        // 6.资源释放
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void testFindUserById() throws IOException {

        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        User user = mapper.findUserById(45);
        System.out.println("user = " + user);

        sqlSession.clearCache();

        User user1 = mapper.findUserById(45);
        System.out.println("user1 = " + user1);

        System.out.println(user == user1);
    }

    @Test
    public void testFindUserById222() throws IOException {

        SqlSession sqlSession1 = factory.openSession();
        IUserDao mapper = sqlSession1.getMapper(IUserDao.class);
        User user1 = mapper.findUserById(45);
        System.out.println("user1 = " + user1);

        sqlSession1.close();// 清除一级缓存

        SqlSession sqlSession2 = factory.openSession();
        IUserDao mapper2 = sqlSession2.getMapper(IUserDao.class);
        User user2 = mapper2.findUserById(45);
        System.out.println("user2 = " + user2);

        System.out.println(user1 == user2);
    }

}
