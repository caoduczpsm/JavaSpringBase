package com.ncaoduc.demospringboot.demo.model.dto;


public class StudentDto {

    private int ID;
    private String userName;

    public StudentDto(){}

    public StudentDto(int id, String userName) {
        super();
        this.userName = userName;
        this.ID = id;
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


}
