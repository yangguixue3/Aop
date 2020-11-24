package com.msr.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@MyTable("user")
public class User {
    @MyColumn("id")
    private Integer id;
    @MyColumn("name")
    private String name;
    @MyColumn("address")
    private String address;
    @MyColumn("age")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

/**
 * 模拟 通过反射 获取注解的属性名，生成sql
 */
class Test{

    /**
     * 测试 获取 sql 文
     * @param args
     */

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        User u1 = new User();
        User u2 = new User();
        u1.setId(1);
        u2.setId(2);
        getSql(u1);
        getSql(u1);


    }

    private static void getSql(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class aClass = user.getClass();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from ");
        // 判断 注解 是不是 @MyTable
        if (aClass.isAnnotationPresent(MyTable.class)) {
            // 获取 注解对象后，强转为MyTable
            MyTable myTable = (MyTable) aClass.getAnnotation(MyTable.class);
            //获取表名
            String tableName = myTable.value();
            stringBuilder.append(tableName+" ");
        }
        Field[] fields = aClass.getDeclaredFields();

        for (Field field : fields) {
            String columnName;
            if (field.isAnnotationPresent(MyColumn.class)) {
                MyColumn column = field.getAnnotation(MyColumn.class);
                columnName = column.value();
            } else {
                continue;
            }
            // 通过属性名，生成get字符串，通过反射获取get方法
            String fieldName = field.getName();
            String getMethodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method method = aClass.getMethod(getMethodName);
            //通过 get方法，获取值
            Object fieldValue = method.invoke(user);

            if (fieldValue == null || ((fieldValue instanceof Integer) && (Integer) fieldValue == 0)) {
                continue;
            }
            if (fieldValue instanceof Integer) {
                stringBuilder.append(columnName + "=" + fieldValue);
            }
            if (fieldValue instanceof String) {
                stringBuilder.append(columnName + "=" + "'" + fieldValue + "'");
            }
        }
            System.out.println(stringBuilder.toString());

    }

}