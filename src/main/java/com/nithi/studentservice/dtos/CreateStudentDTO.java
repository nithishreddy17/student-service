package com.nithi.studentservice.dtos;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nithi.studentservice.student.Student;

import java.time.LocalDate;
import java.time.Period;

public class CreateStudentDTO {
    private String name;
    private String email;
    @JsonDeserialize
    private LocalDate dob;

    public CreateStudentDTO() {
    }

    public CreateStudentDTO(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Student{" +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }

    public static Student toStudent(CreateStudentDTO dto){
        return new Student(dto.getName(), dto.getEmail(), dto.getDob());
    }
}
