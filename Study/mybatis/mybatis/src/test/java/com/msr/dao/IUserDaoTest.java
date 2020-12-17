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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
//        sqlSession = factory.openSession(true);//自动提交事务
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
    public void testFindAll() throws IOException {
        // 5.使用代理对象来执行函数
        List<User> userList = mapper.findAll();
        // 遍历
        userList.stream().forEach(user -> System.out.println("user = " + user));
    }


    @Test
    public void testFindById() throws IOException {
        // 5.使用代理对象来执行函数
        User user = mapper.findById(46);
        System.out.println("user = " + user);
    }


    @Test
    public void testSaveUser() throws IOException, ParseException {
        // 5.使用代理对象来执行函数
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-16");
        User user = new User(null,"Tom11",date,"男","东京");
        System.out.println("新增前 = " + user);
        mapper.saveUser(user);
        System.out.println("新增后 = " + user);
    }

    @Test
    public void testUpdateUserById() throws IOException, ParseException {
        // 5.使用代理对象来执行函数
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-16");
        User user = new User(59,"小新",date,"女","纽约");
        mapper.updateUserById(user);
    }


    @Test
    public void testDeleteUserById() throws IOException, ParseException {
        // 5.使用代理对象来执行函数
        mapper.deleteUserById(58);
    }


    @Test
    public void testFindAllByUsername() throws IOException, ParseException {
        // 5.使用代理对象来执行函数
        // List<User> userList = mapper.findAllByName("%王%");
        List<User> userList = mapper.findAllByName("王");

        userList.stream().forEach(user -> System.out.println("user = " + user));
    }
    @Test
    public void testFindAllTotal() throws IOException, ParseException {
        // 5.使用代理对象来执行函数
        int allTotal = mapper.findAllTotal("_王%");
        System.out.println("allTotal = " + allTotal);
    }
}
