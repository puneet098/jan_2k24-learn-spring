package com.example.data.course.springdatajpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.data.course.Course;

@Component
public class CourseSpringDataJpaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(7, "Learn AWS Spring Data Jpa!", "in28minutes"));
		repository.save(new Course(8, "Learn Azure Spring Data Jpa!", "in28minutes"));
		repository.save(new Course(9, "Learn DevOps Spring Data Jpa!", "in28minutes"));
		repository.deleteById(7l);
		System.out.println("****************************findById");
		System.out.println(repository.findById(8l));
		System.out.println(repository.findById(9l));
		System.out.println("****************************findAll");
		System.out.println(repository.findAll());
		System.out.println("****************************findByAuthor");
		System.out.println(repository.findByAuthor("in28minutes"));
	}

}
