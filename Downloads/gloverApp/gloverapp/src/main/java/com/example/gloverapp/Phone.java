package com.example.gloverapp;

import javax.persistence.*;

@Entity
public class Phone {

    @Id
    private int id;

    @Column(name = "ANDROID")
    private String android;

    @Column(name = "IPHONE")
    private String iphone;

    @ManyToOne
    @JoinColumn(name = "STUDENTS_PHONE")
    private Student student;

    public Phone(int id, String android, String iphone, Student student) {
        this.id = id;
        this.android = android;
        this.iphone = iphone;
        this.student = student;
    }

    public Phone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", android='" + android + '\'' +
                ", iphone='" + iphone + '\'' +
                ", student=" + student +
                '}';
    }
}
