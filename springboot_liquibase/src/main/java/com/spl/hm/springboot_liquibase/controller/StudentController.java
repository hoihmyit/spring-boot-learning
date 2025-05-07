package com.spl.hm.springboot_liquibase.controller;

import java.util.List;

import com.spl.hm.springboot_liquibase.dto.StudentDto;
import com.spl.hm.springboot_liquibase.entity.Student;
import com.spl.hm.springboot_liquibase.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentController {

    private final StudentService studentService;

    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getStudents() {
        List<StudentDto> studentDtos = studentService.getAllStudents();
        return ResponseEntity.ok(studentDtos);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudents(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return ResponseEntity.ok(student);
    }
}
