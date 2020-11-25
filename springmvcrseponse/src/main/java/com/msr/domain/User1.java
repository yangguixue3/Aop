package com.msr.domain;

import java.io.Serializable;
import java.util.Date;

public class User1 implements Serializable{


        private String username;
        private String password;
        private Date birthday;


    public User1(String username, String password, Date birthday) {
        this.username = username;
        this.password = password;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return password;
    }

    public void setAge(String age) {
        this.password = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public User1() {
        }


}
