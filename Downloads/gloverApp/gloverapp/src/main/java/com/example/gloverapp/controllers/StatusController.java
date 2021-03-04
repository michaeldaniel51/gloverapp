package com.example.gloverapp.controllers;

import com.example.gloverapp.entities.Status;
import com.example.gloverapp.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/status")
    public List<Status> getAllStatus(){
      return statusService.getAllStatus();

    }

    @PostMapping("/status")
    public void addStatus(@RequestBody Status status){
        statusService.addStatus(status);
    }

    @DeleteMapping("/status/{id}")
    public void deleteStatus(@PathVariable String id){
        statusService.deleteById(id);
    }

    @GetMapping("/status/{id}")
    public Optional<Status> getStatusById(@PathVariable String id){
        return statusService.getStatusById(id);
    }

    @PutMapping("/status/{id}")
    public void updateStatus(@RequestBody Status status,@PathVariable String id){
        statusService.updateStatus(status,id);
    }

    @GetMapping("/status/posts/{post}")
    public Optional<Status> getStatusByPost(@PathVariable String post){
       return statusService.getStatusByPost(post);
    }

}
