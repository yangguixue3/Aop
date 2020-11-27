# ssm搭建过程记录.md #

## 1.创建servlet-web 工程，文件目录结构 ##

## 2.pom.xml 依赖 ##

## 3.先配置spring ##

    1.domain层实体类 
    2.dao层
    3.service层 以及实现类serviceIpml，添加组件注解@Service("")
    3.ApplicationSpringConfig.xml、开启注解扫描
    4.编写测试类，测试 service层

## 4.配置Springmvc ##

    1.目录 WEB-INF下，
        - 建立静态资源文件夹，HTML CSS JS 等。
        - WEB-INF/pages/success.jsp 页面
    2.该配置文件配置:
        - 开启Spring的注解扫描 
        - 配置视图解析器
        - 配置过滤静态资源
        - 开启springMVC注解支持 适配器 和 映射器
    3.配置web.xml
        - 通过springMVC的过滤器 配置字符编码过滤
        - 配置前端控制器 DispatcherServlet，设置初始化加载配置springMVC.xml文件，设置初始化顺序
    4.index.jsp页面
    5.controller
    4.配置tomact，进行url 测试跳转success页面，成功

## 5.spring整合Springmvc ##

    1.在项目启动的时候，就去加载SpringApplicationContext.xml的配置文件。在web.xml中配置:
        - 在ContextLoaderListener监听器（该监听器只能加载WEB-INF目录下的配置文件，如果xml配置文件放在该目录下，不用配置。)??? 实际配置中没有配置，controller也能调用service层
    2.测试 在controller中能成功的调用service对象中的方法。

## 6.Spring整合MyBatis框架 ##

### 首先搭建测试Mybatis环境 ###

