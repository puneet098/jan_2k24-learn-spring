package com.example.data.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.data.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {

	List<Course> findByAuthor(String author);
}
