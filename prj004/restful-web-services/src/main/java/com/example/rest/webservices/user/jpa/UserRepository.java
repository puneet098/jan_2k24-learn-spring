package com.example.rest.webservices.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rest.webservices.User;



public interface UserRepository extends JpaRepository<User,Integer>{
	

}
