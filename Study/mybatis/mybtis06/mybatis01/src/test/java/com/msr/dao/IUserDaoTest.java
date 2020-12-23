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
        List<User> users = mapper.findAll();

        users.stream().forEach(user -> {
            System.out.println("user = " + user);
            System.out.println("\t\t\t" + user.getAccounts());
        });
    }

    @Test
    public void testFindUserById() throws IOException {
        // 5.使用代理对象来执行函数
        User user = mapper.findUserById(45);
        System.out.println("user = " + user);
    }

    @Test
    public void testAddUser() throws IOException, ParseException {
        // 5.使用代理对象来执行函数
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-12");
        User user = new User(null,"dada",birthday,"女","南阳");
        mapper.addUser(user);
    }

    @Test
    public void testUpdateUserById() throws IOException, ParseException {
        // 5.使用代理对象来执行函数
        Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse("2020-12-12");
        User user = new User(42,"xiaoxiao",birthday,"女","南阳");
        mapper.updateUserById(user);
    }

    @Test
    public void testDeleteUserById() throws IOException {
        // 5.使用代理对象来执行函数
        mapper.deleteUserById(50);
    }





}
