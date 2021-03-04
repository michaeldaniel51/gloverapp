package com.example.gloverapp.repositories;

import com.example.gloverapp.entities.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationRepository extends CrudRepository <Location,String> {

    Optional<Location> findByName(String name);

}
