package com.example.gloverapp.repositories;

import com.example.gloverapp.entities.Location;
import com.example.gloverapp.entities.Status;
import com.example.gloverapp.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository <Student,Integer> {


     List<Student> findByGender(String gender);

     List<Student> findByLocationId(String id);
}
