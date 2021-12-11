package com.example.recriutingsystem;

public class Message {
    private int bUid,jUid,type;
    private String massage,time;

    public Message(int bUid, int jUid, String massage, String time) {
        this.bUid = bUid;
        this.jUid = jUid;
        this.massage = massage;
        this.time = time;
    }
    public Message(){}

    public int getbUid() {
        return bUid;
    }

    public void setbUid(int bUid) {
        this.bUid = bUid;
    }

    public int getjUid() {
        return jUid;
    }

    public void setjUid(int jUid) {
        this.jUid = jUid;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
