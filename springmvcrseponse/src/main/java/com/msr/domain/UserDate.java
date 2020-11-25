package com.msr.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 带有日期类型的 类
 */

public class UserDate implements Serializable {


    private String userName;
    private Integer password;
    private Date birthday;
    public UserDate(){}
    public UserDate(String userName, Integer password, Date birthday) {
        this.userName = userName;
        this.password = password;
        this.birthday = birthday;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserDate{" +
                "userName='" + userName + '\'' +
                ", password=" + password +
                ", birthday=" + birthday +
                '}';
    }
}
