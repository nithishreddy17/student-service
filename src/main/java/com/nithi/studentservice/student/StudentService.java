package com.nithi.studentservice.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
   /* public List<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }*/

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalStateException("Email already exists");
        }
        studentRepository.save(student);
    }
    @PutMapping(path = "{id}")
    public void deleteStudent(Long studentId){
    boolean exists = studentRepository.existsById(studentId);
    if(!exists){
        throw new IllegalStateException("student with id "+studentId+ " does not exists");
    }
    studentRepository.deleteById(studentId);
    }
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("Student with ID "+id+" does not exists"));
        if(name != null && name.length()>0 && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }
        if(email != null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }
    }
}
