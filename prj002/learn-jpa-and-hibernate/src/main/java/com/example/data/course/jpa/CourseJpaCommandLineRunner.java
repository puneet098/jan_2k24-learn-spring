package com.example.data.course.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.data.course.Course;

@Component
public class CourseJpaCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(4, "Learn AWS Jpa!", "in28minutes"));
		repository.insert(new Course(5, "Learn Azure Jpa!", "in28minutes"));
		repository.insert(new Course(6, "Learn DevOps Jpa!", "in28minutes"));
		repository.deleteById(4);
		System.out.println("****************************CourseJpaRepository");
		System.out.println(repository.findById(5));
		System.out.println(repository.findById(6));
	}

}
