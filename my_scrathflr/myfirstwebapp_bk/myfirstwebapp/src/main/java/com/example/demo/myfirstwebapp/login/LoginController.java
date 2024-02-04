package com.example.demo.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("login")
	public String gotoLoginPage(@RequestParam String name, ModelMap map ) {
		map.put("name", name);
		System.out.println("name ;-->"+name);//not recommended
		return "login";
	}
}
