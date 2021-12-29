package com.example.recriutingsystem.entity;

public class Recruit {
    private int uid,rid;
    private String jobName,jobDescription,workCity,degree,expRequire,salaryOffer,offerNumber,email;

    public Recruit(int uid, int rid, String jobName, String jobDescription, String workCity, String degree, String expRequire, String salaryOffer, String offerNumber, String email) {
        this.uid = uid;
        this.rid = rid;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.workCity = workCity;
        this.degree = degree;
        this.expRequire = expRequire;
        this.salaryOffer = salaryOffer;
        this.offerNumber = offerNumber;
        this.email = email;
    }
    public Recruit(){};
    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getWorkCity() {
        return workCity;
    }

    public void setWorkCity(String workCity) {
        this.workCity = workCity;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExpRequire() {
        return expRequire;
    }

    public void setExpRequire(String expRequire) {
        this.expRequire = expRequire;
    }

    public String getSalaryOffer() {
        return salaryOffer;
    }

    public void setSalaryOffer(String salaryOffer) {
        this.salaryOffer = salaryOffer;
    }

    public String getOfferNumber() {
        return offerNumber;
    }

    public void setOfferNumber(String offerNumber) {
        this.offerNumber = offerNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
}
