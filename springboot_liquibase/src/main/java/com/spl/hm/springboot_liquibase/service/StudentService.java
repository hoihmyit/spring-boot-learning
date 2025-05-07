package com.spl.hm.springboot_liquibase.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.spl.hm.springboot_liquibase.dto.StudentDto;
import com.spl.hm.springboot_liquibase.entity.Student;
import com.spl.hm.springboot_liquibase.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream()
            .map(StudentDto::new)
            .collect(Collectors.toList());
    }

    public Student getStudentById(Long studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if (optionalStudent.isEmpty()) {
            return new Student();
        }

        return optionalStudent.get();
    }
}
