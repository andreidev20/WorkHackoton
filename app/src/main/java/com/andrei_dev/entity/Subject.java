package com.andrei_dev.entity;

/**
 * Created by annap on 04.12.2017.
 */

public class Subject {
    private int id;
    private String data;
    private int couple;
    private String subject;

public Subject(){

}
    public Subject(int id, String data, int couple, String subject) {
        this.id = id;
        this.data = data;
        this.couple = couple;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCouple() {
        return couple;
    }

    public void setCouple(int couple) {
        this.couple = couple;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}



