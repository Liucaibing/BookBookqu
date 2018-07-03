package com.example.demo.entity;

public class User {
    String account;
    String password;

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount(){
        return account;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String toString(){
        return "User{"+
                "account='"+account+'\''+
                ",password='"+password+'\''+
                "}";
    }
}
