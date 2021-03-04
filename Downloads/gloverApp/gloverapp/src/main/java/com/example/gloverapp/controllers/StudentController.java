package com.example.gloverapp.controllers;

import com.example.gloverapp.entities.Student;
import com.example.gloverapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(){
       return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable int id){
       return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentService.saveStudent(student);

    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteById(id);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@RequestBody Student student,@PathVariable int id){
        studentService.updateStudent(student,id);
    }

    @GetMapping("/students/gender/{gender}")
    public List<Student> findByGender(@PathVariable String gender){
        return studentService.findByGender(gender);
    }


    @GetMapping("/students/location/{id}")
    public List<Student> getLocationBy(@PathVariable String id){
        return studentService.getStudentByLocationId(id);

    }


}
