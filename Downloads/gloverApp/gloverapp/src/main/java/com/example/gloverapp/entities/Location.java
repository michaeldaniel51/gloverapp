package com.example.gloverapp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    private String id;

    @Column(name = "LOCATION_NAME")
    private  String name;


    public Location(String id, String name) {
        this.id = id;
        this.name = name;

    }



    public Location() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
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
