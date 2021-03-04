package com.example.gloverapp.services;


import com.example.gloverapp.entities.Location;
import com.example.gloverapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {


    @Autowired
    private LocationRepository locationRepository;


    public List<Location> getAllLocation(){
        List<Location> location = new ArrayList<>();
        locationRepository.findAll().forEach(location::add);

        return location;
    }
    public Optional<Location> getById(String id){
        Optional<Location> location = locationRepository.findById(id);
        return location;
    }


    public void addLocation(Location location){
        locationRepository.save(location);

    }

    public void deleteLocation(String id){
        locationRepository.deleteById(id);
    }

    public void updateLocation(Location location,String id){
        locationRepository.save(location);
    }

    public Optional<Location> getLocationByName(String name){
        return locationRepository.findByName(name);
    }

}
