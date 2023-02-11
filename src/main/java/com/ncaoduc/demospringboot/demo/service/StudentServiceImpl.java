package com.ncaoduc.demospringboot.demo.service;

import com.ncaoduc.demospringboot.demo.exception.NotFoundException;
import com.ncaoduc.demospringboot.demo.model.Student;
import com.ncaoduc.demospringboot.demo.model.dto.StudentDto;
import com.ncaoduc.demospringboot.demo.model.mapper.StudentMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentServiceImpl implements StudentService{

    private static final List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "Nguyễn Văn Vui", "abc"));
        students.add(new Student(2, "Trần Văn Cười", "xyz"));
        students.add(new Student(3, "Bùi Thị Buồn", "mpq"));
        students.add(new Student(4, "Phan Văn Khóc", "ijk"));
        students.add(new Student(5, "Lý Văn Giận", "qwe"));
        students.add(new Student(6, "Quách thị Quạo", "ghj"));
    }

    @Override
    public List<StudentDto> getListStudent() {
        List<StudentDto> dto = new ArrayList<>();
        for (Student student : students){
            dto.add(StudentMapper.toStudentDTO(student));
        }
        return dto;
    }

    @Override
    public StudentDto getStudentById(String id) {
        for (Student student : students){
            if (student.getID() == Integer.parseInt(id))
                return StudentMapper.toStudentDTO(student);
        }
        throw new NotFoundException("Không tìm thấy student tương ứng.");
    }

    @Override
    public List<StudentDto> searchStudent(String keyword) {
        List<StudentDto> dtos = new ArrayList<>();
        for (Student student : students){
            if (student.getUserName().contains(keyword))
                dtos.add(StudentMapper.toStudentDTO(student));

        }
        return dtos;
    }
}
