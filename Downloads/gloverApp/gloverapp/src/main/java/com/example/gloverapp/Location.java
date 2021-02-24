package com.example.gloverapp;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {

    @Id
    @Column(name = "LOCATION_ID")
    private String id;

    @Column(name = "LOCATION_NAME")
    private  String name;

    @OneToMany
    @JoinColumn(name = "STUDENT_LOCATION")
    private List<Student> student;


    public Location(String id, String name, List<Student> student) {
        this.id = id;
        this.name = name;
        this.student = student;
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

    public List<Student> getStudent() {
        return student;
    }

    public void setStudent(List<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", student=" + student +
                '}';
    }
}
