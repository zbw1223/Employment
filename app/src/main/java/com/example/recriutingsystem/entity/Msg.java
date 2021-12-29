package com.example.recriutingsystem.entity;

public class Msg {
    private int source,destination;
    private String message,time;

    public Msg(int source, int destination, String message, String time) {
        this.source = source;
        this.destination = destination;
        this.message = message;
        this.time = time;
    }
    public Msg(){}

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }
}
