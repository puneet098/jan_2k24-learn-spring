package com.example01.springboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CourseController {

	//Courses
	//Course: id, name, author
	@GetMapping("/courses")
	public List<Course> retrieveAllCourse() {
		return Arrays.asList(
				new Course(1, "Learn AWS", "In28Minutes"),
				new Course(2, "Learn DevOps", "In28Minutes"),
				new Course(3, "Learn Azure", "In28Minutes")
				
				
				);
	}
}
