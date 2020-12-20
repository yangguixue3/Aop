package com.msr.domain;

/**
 *
 */
public class AccountUser extends Account {

    private String userName;
    private String userAddress;

    public AccountUser() {
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "account='" + super.toString() + '\'' +
                "userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
