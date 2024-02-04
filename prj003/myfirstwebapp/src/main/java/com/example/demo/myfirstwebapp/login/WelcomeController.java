package com.example.demo.myfirstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	//login
	@GetMapping("/")
	public String goToWelcomePage(ModelMap model) {
		model.put("name", getLogggedInUser());
		return "welcome";
	}
	
	private String getLogggedInUser() {
		Authentication auth = 
				SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		return user;
	}
}
