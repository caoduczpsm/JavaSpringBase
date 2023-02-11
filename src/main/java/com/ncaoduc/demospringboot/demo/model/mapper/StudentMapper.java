package com.ncaoduc.demospringboot.demo.model.mapper;

import com.ncaoduc.demospringboot.demo.model.dto.StudentDto;
import com.ncaoduc.demospringboot.demo.model.Student;

public class StudentMapper {
    public static StudentDto toStudentDTO (Student student){
        StudentDto dto = new StudentDto();
        dto.setID(student.getID());
        dto.setUserName(student.getUserName());
        return dto;
    }
}
