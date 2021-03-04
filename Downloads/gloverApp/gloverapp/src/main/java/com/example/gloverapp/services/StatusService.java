package com.example.gloverapp.services;

import com.example.gloverapp.entities.Status;
import com.example.gloverapp.entities.Student;
import com.example.gloverapp.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;


    public List<Status> getAllStatus(){
        List<Status> status = new ArrayList<>();
        statusRepository.findAll().forEach(status::add);
        return  status;
    }

    public void addStatus(Status status){
        statusRepository.save(status);
    }

    public Optional<Status> getStatusById(String id){
        Optional<Status> status = statusRepository.findById(id);
        return status;
    }

    public void updateStatus(Status status,String id){
        statusRepository.save(status);
    }

    public void deleteById(String id){
        statusRepository.deleteById(id);
    }


    public Optional<Status> getStatusByPost(String post){
      return   statusRepository.findStatusByPost(post);
    }

}
