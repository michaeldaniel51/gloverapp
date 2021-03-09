package com.example.gloverapp.controllers;

import com.example.gloverapp.entities.Location;
import com.example.gloverapp.entities.Student;
import com.example.gloverapp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {


    @Autowired
    private LocationService locationService;


    @GetMapping("/locations")
    private List<Location> getAllLocation(Model model){
      return locationService.getAllLocation();
    }

    @PostMapping("/locations")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }


    /**
     * location cannot be deleted by id
     * because it has a relationship with the Student entity
     * @param id
     */
    @DeleteMapping("/locations/{id}")
    public void deleteLocation(@PathVariable long id){
        locationService.deleteLocation(id);
    }

    @PutMapping("/locations/{id}")
    public void updateLocation(@RequestBody Location location,@PathVariable long id){
        locationService.updateLocation(location,id);
    }

    @GetMapping("/locations/{id}")
    public Optional<Location> getById(@PathVariable long id){
       return locationService.getById(id);
    }



}