package com.ncaoduc.demospringboot.demo.service;

import com.ncaoduc.demospringboot.demo.model.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<StudentDto> getListStudent();

    StudentDto getStudentById(String id);

    List<StudentDto> searchStudent(String keyword);

}
