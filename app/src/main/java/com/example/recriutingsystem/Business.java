package com.example.recriutingsystem;

public class Business {
    private int uid;
    private String businessName,city,email,introduce;

    public Business(int uid, String businessName, String city, String email, String introduce) {
        this.uid = uid;
        this.businessName = businessName;
        this.city = city;
        this.email = email;
        this.introduce = introduce;
    }
    public Business(){};

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
