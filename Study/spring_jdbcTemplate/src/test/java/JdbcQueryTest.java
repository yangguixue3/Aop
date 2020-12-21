import com.msr.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcQueryTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;//引用类型

    //集合查询
    @Test
    public void test1(){
        //1:sql
        //2:接口 -- 》 实现类  --》Bean....
        List<Account> list = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : list) {
            System.out.println(account.getName()+","+account.getMoney());
        }
    }

    /**
     * 查询单个实体
     */
    @Test
    public void test2(){
        //方式一：
        /*List<Account> list = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "tom");
        for (Account account : list) {
            System.out.println(account.getName()+","+account.getMoney());
        }*/

        //方式二：
        Account zs = jdbcTemplate.queryForObject("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), "zs");
        System.out.println(zs);
    }


    /**
     * 统计account表中的记录数：count
     */
    @Test
    public void test3(){
        Long count = jdbcTemplate.queryForObject("select count(*) from account", Long.class);//int Long
        System.out.println(count);
    }

}
