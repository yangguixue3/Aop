package com.msr.dao;

import com.msr.domain.Role;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 */
public class RoleDaoTest {

    private InputStream inputStream ;
    private SqlSessionFactoryBuilder builder;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private RoleDao mapper;

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
        mapper = sqlSession.getMapper(RoleDao.class);
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
        List<Role> roleList = mapper.findAll();
        // 遍历
       roleList.stream().forEach(role -> {
           System.out.println("role = " + role);
           System.out.println("\t\t\t" + role.getUsers());
       });
    }

}
