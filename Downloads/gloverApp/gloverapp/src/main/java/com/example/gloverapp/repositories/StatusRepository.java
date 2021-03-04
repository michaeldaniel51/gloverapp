package com.example.gloverapp.repositories;

import com.example.gloverapp.entities.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends CrudRepository<Status,String> {

    Optional<Status> findStatusByPost(String post);

}
