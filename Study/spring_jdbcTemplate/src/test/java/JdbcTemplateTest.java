import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;


public class JdbcTemplateTest {
    @Test
    public void test1() throws  Exception{
        //创建数据源对象
        //ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/store?serverTimezone=UTC");
//        dataSource.setUser("root");
//        dataSource.setPassword("123456");

        //加入到配置文件当中

        //JdbcTemplate jdbcTemplate = new JdbcTemplate();
        //设置数据源对象
        //jdbcTemplate.setDataSource(dataSource);//引用数据类型的赋值  ref
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");

        //执行操作(dml操作：增、修、删)  2个？  动态参数
        int row = jdbcTemplate.update("insert into account values(?,?,?)", null,"zs", 5000);
        System.out.println(row);//1 受影响的行数
    }


    //转账业务
    @Test
    public void test2(){
        //jdbcTeamplate
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");

        //执行sql语句  tom  给 zs  转 500
        jdbcTemplate.update("update account set  money=money-500 where name = ?","tom");

        //zs 增加 500
        jdbcTemplate.update("update account set  money=money+500 where name = ?","zs");
    }
}
