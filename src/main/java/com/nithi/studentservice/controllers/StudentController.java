package com.nithi.studentservice.controllers;

import com.nithi.studentservice.student.CreateStudentDTO;
import com.nithi.studentservice.student.Student;
import com.nithi.studentservice.student.StudentService;
import com.nithi.studentservice.student.UpdateStudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    /*@GetMapping("/{id}")
    public List<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }*/

    @PostMapping
    // use JSR-303 - TODO
    public void registerNewStudent(@RequestBody CreateStudentDTO createStudentDTO) {
        Student student = CreateStudentDTO.toStudent(createStudentDTO);
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }

//    @PutMapping(path = "/{id}")
//    public Student updateStudent(
//            @PathVariable("id") Long id, @RequestBody UpdateStudentDTO student) {
//        studentService.updateStudent(id, name, email);
//    }
}
