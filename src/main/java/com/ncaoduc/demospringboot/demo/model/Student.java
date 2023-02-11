package com.ncaoduc.demospringboot.demo.model;

import org.springframework.stereotype.Component;

public class Student {

    private int ID;
    private String userName;
    private String pass;


    public Student(int id, String userName, String pass) {
        super();
        this.userName = userName;
        this.ID = id;
        this.pass = pass;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
