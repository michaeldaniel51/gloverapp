package com.example.gloverapp;

import com.example.gloverapp.entities.Location;
import com.example.gloverapp.entities.Status;
import com.example.gloverapp.entities.Student;
import com.example.gloverapp.repositories.LocationRepository;
import com.example.gloverapp.repositories.StatusRepository;
import com.example.gloverapp.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class GloverApplication implements CommandLineRunner {

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	StatusRepository statusRepository;

	@Autowired
	StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(GloverApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {


		Location location1 = new Location(15, "abuja");
		Location location2 = new Location(16, "abia");
		Location location3 = new Location(17, "abia");
		Location location4 = new Location(18, "lekki");


		List<Location> l = Arrays.asList(location1, location2, location3, location4);

		locationRepository.saveAll(l);
		System.out.println(l);

		Student student1 = new Student("daniel", "michael", 0706, "danny@gmail.com", "male", "1111", 12, "bus-admin",location1);
		Student student2 = new Student("mary", "kay", 0707, "mary@gmail.com", "female", "2222", 13, "economics",location2);
		Student student3 = new Student("john", "moss", 0705, "john@gmail.com", "male", "3333", 15, "science",location3);
		Student student4 = new Student("grace", "love", 0703, "grace@gmail.com", "female", "4444", 16, "agric",location4);


		List<Student> s = Arrays.asList(student1, student2, student3, student4);

		studentRepository.saveAll(s);

		System.out.println(s);

		Status status1 = new Status("1", "i love you", LocalDate.now(), student3);
		Status status2 = new Status("2", "i know you", LocalDate.now(), student2);
		Status status3 = new Status("3", "time to sleep", LocalDate.now(), student1);
		Status status4 = new Status("4", "i have money", LocalDate.now(), student4);


		List<Status> st = Arrays.asList(status1, status2, status3, status4);

		statusRepository.saveAll(st);

		System.out.println(st);


	}
}