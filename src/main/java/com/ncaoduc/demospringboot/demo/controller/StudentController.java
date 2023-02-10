package com.ncaoduc.demospringboot.demo.controller;

import com.ncaoduc.demospringboot.demo.model.dto.StudentDto;
import com.ncaoduc.demospringboot.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController()
@RequestMapping("/student")
public class StudentController {

    // http://localhost:8080/student
    @Autowired
    private StudentService studentService;

    @GetMapping()
    public ResponseEntity<?> getStudent() {
        List<StudentDto> students;
        students = studentService.getListStudent();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable String id) {
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(studentDto);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchStudentByName(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
        List<StudentDto> studentDto = studentService.searchStudent(name);
        return ResponseEntity.status(HttpStatus.OK).body(studentDto);
    }

    @PostMapping()
    public ResponseEntity<?> createStudent() {
        return null;
    }
    @PutMapping()
    public ResponseEntity<?> updateStudent() {
        return null;
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteStudent() {
        return null;
    }
}
