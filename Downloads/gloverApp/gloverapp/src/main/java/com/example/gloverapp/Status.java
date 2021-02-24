package com.example.gloverapp;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Status {

    @Id
    @Column(name = "STATUS_ID")
    private String id;

    @Column(name = "POSTS")
    private String post;

    @Column(name = "TIME_STATUS_UPDATED")
    private LocalDate timeStatusPosted = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "STUDENTS_STATUS")
    private Student student;

    public Status(String id, String post, LocalDate timeStatusPosted, Student student) {
        this.id = id;
        this.post = post;
        this.timeStatusPosted = LocalDate.now();
        this.student = student;
    }


    public Status() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public LocalDate getTimeStatusPosted() {
        return timeStatusPosted;
    }

    public void setTimeStatusPosted(LocalDate timeStatusPosted) {
        this.timeStatusPosted = LocalDate.now();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id='" + id + '\'' +
                ", post='" + post + '\'' +
                ", timeStatusPosted=" + timeStatusPosted +
                ", student=" + student +
                '}';
    }
}

