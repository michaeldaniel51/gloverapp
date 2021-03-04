package com.example.gloverapp.entities;

import com.example.gloverapp.entities.Location;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private  String lastName;

    @Column(name = "PHONE_NUMBER")
    private long phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "AGE")
    private int age;

    @Column(name = "DEPARTMENT")
    private  String department;

    @ManyToOne
    private Location location;


    public Student(String firstName, String lastName, long phoneNumber, String email, String gender, String password, int age, String department, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
        this.password = password;
        this.age = age;
        this.department = department;
        this.location = location;

    }


    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", location=" + location +
                '}';
    }
}
