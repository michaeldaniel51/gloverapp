package com.example.gloverapp.controllers;

import com.example.gloverapp.entities.Location;
import com.example.gloverapp.entities.Student;
import com.example.gloverapp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController {


    @Autowired
    private LocationService locationService;


    @GetMapping("/location")
    private List<Location> getAllLocation(){
        return locationService.getAllLocation();
    }

    @PostMapping("/Location")
    public void addLocation(@RequestBody Location location){
        locationService.addLocation(location);
    }

    @DeleteMapping("/location/{id}")
    public void deleteLocation(@PathVariable String id){
        locationService.deleteLocation(id);

    }

    @PutMapping("/location/{id}")
    public void updateLocation(@RequestBody Location location,@PathVariable String id){
        locationService.updateLocation(location,id);
    }

    @GetMapping("/location/{id}")
    public Optional<Location> getById(@PathVariable String id){
       return locationService.getById(id);
    }

    @GetMapping("/location/{name}")
    public Optional<Location> getLocationByName(@PathVariable String name){
        return locationService.getLocationByName(name);
    }

}
