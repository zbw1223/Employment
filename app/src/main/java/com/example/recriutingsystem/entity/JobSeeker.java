package com.example.recriutingsystem.entity;

public class JobSeeker {
    private int uid;
    private String name,sex,birthday,exp,degree,eduBackground,major,job,city,salary,email;

    public JobSeeker(int uid, String name, String sex, String birthday, String exp, String degree, String eduBackground, String major, String job, String city, String salary, String email) {
        this.uid = uid;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.exp = exp;
        this.degree = degree;
        this.eduBackground = eduBackground;
        this.major = major;
        this.job = job;
        this.city = city;
        this.salary = salary;
        this.email = email;
    }
    public JobSeeker(){};

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEduBackground() {
        return eduBackground;
    }

    public void setEduBackground(String eduBackground) {
        this.eduBackground = eduBackground;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
