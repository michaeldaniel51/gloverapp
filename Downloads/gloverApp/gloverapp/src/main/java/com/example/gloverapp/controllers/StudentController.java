package com.example.gloverapp.controllers;

import com.example.gloverapp.entities.Student;
import com.example.gloverapp.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> getAllStudents(Model model){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable long id) throws Exception {
       return studentService.getStudentById(id);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentService.saveStudent(student);

    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable long id){
        studentService.deleteById(id);
    }

    @PutMapping("/students/{id}")
    public void updateStudent(@RequestBody Student student,@PathVariable long id){
        studentService.updateStudent(student,id);
    }

    @GetMapping("/students/gender/{gender}")
    public List<Student> findByGender(@PathVariable String gender){
        return studentService.findByGender(gender);
    }


   @GetMapping("/students/location/{id}")
   public List<Student> getLocationBy(@PathVariable long id){
       return studentService.getStudentByLocationId(id);

    }


}
