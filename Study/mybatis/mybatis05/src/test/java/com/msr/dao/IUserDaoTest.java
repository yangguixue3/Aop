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

/**
 * @author 辉
 * @create 2020-12-15 17:03
 * @desc
 */
public class IUserDaoTest {

    private InputStream inputStream ;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private IUserDao mapper;

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
        // 4.创建Dao接口的代理对象
        mapper = sqlSession.getMapper(IUserDao.class);
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
        // 一级缓存 指sqlSession 存储的是对象
        SqlSession sqlSession1 = factory.openSession();
        mapper = sqlSession1.getMapper(IUserDao.class);
        User user1 = mapper.findById(45);
        System.out.println("user1 = " + user1);
//        sqlSession1.clearCache();// 清除一级缓存 不清除的话，返回的对象相等
        sqlSession1.close(); // 清除一级缓存 不清除的话，返回的对象相等

        SqlSession sqlSession2 = factory.openSession();
        mapper = sqlSession2.getMapper(IUserDao.class);

        User user2 = mapper.findById(45);
        System.out.println("user2 = " + user2);
        sqlSession1.close();

        System.out.println(user1 == user2);
    }

    @Test
    public void test2() throws IOException {
        // 二级缓存 指SqlSessionFactory
        // SqlSessionFactory 内存中存放的是 上一次查询的数据
        User user1 = mapper.findById(45);
        System.out.println("user1 = " + user1);

        //sqlSession.clearCache();// 清空缓存
        sqlSession.close();
        sqlSession = factory.openSession();
        mapper = sqlSession.getMapper(IUserDao.class);
        User user2 = mapper.findById(45);
        System.out.println("user2 = " + user2);

        System.out.println(user1 == user2);
    }

}
