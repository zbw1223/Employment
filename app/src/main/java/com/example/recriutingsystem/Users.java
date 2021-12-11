package com.example.recriutingsystem;

public class Users {
    private int uid;
    private String uName;
    private String password;
    private int uType;
    public String getuName() {
        return uName;
    }
    public void setuName(String uName) {
        this.uName = uName;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    public int getuType() {
        return uType;
    }
    public void setuType(int uType) {
        this.uType = uType;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
