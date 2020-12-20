package com.msr.domain;

import java.io.Serializable;

/**
 *
 */
public class Account  implements Serializable {

    private Integer accountId;
    private Integer userId;
    private Double money;

    // 体现从属关系
    private User user;

    public Account() {
    }

    public Account(Integer accountId, Integer userId, Double money) {
        this.accountId = accountId;
        this.userId = userId;
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                // user +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", money=" + money +
                '}';
    }
}
