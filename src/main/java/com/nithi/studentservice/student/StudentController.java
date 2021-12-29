package com.nithi.studentservice.student;

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

  /*  @GetMapping("/{id}")
    public List<Student> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }*/

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }
    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id){
    studentService.deleteStudent(id);
    }
}
