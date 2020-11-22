package com.msr.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {
    private String accountName;
    private String password;
    private Double money;
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    private List<User> userList;
    private Map<String, User> userMap;

    public Account() {
    }

    public Account(String accountName, String password, Double money, List<User> userList, Map<String, User> userMap,User user) {
        this.accountName = accountName;
        this.password = password;
        this.money = money;
        this.userList = userList;
        this.userMap = userMap;
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", userList=" + userList +
                ", userMap=" + userMap +
                ", user=" + user +
                '}';
    }
}
