package com.example.demo.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class HardCodedAuthenticationService {
	
	public boolean authenicate(String username, String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("Paul");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");
		
		return isValidUserName && isValidPassword;
	}
}
