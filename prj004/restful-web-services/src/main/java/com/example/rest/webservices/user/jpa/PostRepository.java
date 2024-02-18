package com.example.rest.webservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.webservices.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
