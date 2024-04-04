package com.example.demo.myfirstwebapp.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController_v2 {
	
	//@Autowired
	private HardCodedAuthenticationService hcAuthService
		= new HardCodedAuthenticationService() ;
	
	//login
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name,@RequestParam String password,ModelMap model ) {
		model.put("name", name);
		model.put("password", password);
		
		//Authentication
		//Valid => welcome
		//InValid => login
		if(hcAuthService.authenicate(name, password)) {
		 return "welcome";	
		}
		
		model.put("errorMessage", "Invalid Credinitals. Please Try Again");
		return "login";
	}
}