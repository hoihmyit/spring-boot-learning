package com.spl.hm.springboot_liquibase.dto;

import java.util.Date;

import com.spl.hm.springboot_liquibase.entity.Student;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date createdAt;
    private Date updatedAt;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.phoneNumber = student.getPhoneNumber();
        this.createdAt = student.getCreatedAt();
        this.updatedAt = student.getUpdatedAt();
    }
}
