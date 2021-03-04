package com.example.gloverapp.services;

import com.example.gloverapp.entities.Student;
import com.example.gloverapp.repositories.LocationRepository;
import com.example.gloverapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {



    @Autowired
    private StudentRepository studentRepository;

    private LocationRepository locationRepository;

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Optional<Student> getStudentById(int id){
         Optional<Student> students= studentRepository.findById(id);
         return students;
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student,int id){
        studentRepository.save(student);
    }


    public void deleteById(int id){
        studentRepository.deleteById(id);
    }

    public List<Student> findByGender(String gender) {
    return getAllStudents().stream().filter(t-> t.getGender().equals(gender))
                .collect(Collectors.toList());
     }

     public List<Student>getStudentByLocationId(String id){
        return  studentRepository.findByLocationId(id);
     }


}