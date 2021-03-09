package com.example.gloverapp.entities;

import javax.persistence.*;
import java.util.List;
import java.util.ServiceLoader;

@Entity
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    private long id;

    @Column(name = "LOCATION_NAME")
    private String name;


    public Location(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Location() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';

    }
}