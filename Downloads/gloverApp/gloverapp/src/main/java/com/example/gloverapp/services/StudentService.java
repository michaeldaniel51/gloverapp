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

    public Optional<Student> getStudentById(long id) throws Exception {
         Optional<Student> students= Optional.ofNullable(studentRepository.findById(id).orElseThrow(() -> new Exception("id not found")));
         return students;
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Student student,long id){
        studentRepository.save(student);
    }


    public void deleteById(long id){
        studentRepository.deleteById(id);
    }

    public List<Student> findByGender(String gender) {
    return getAllStudents().stream().filter(t-> t.getGender().equals(gender))
                .collect(Collectors.toList());
     }

     public List<Student>getStudentByLocationId(long id){
        return  studentRepository.findByLocationId(id);
     }


}