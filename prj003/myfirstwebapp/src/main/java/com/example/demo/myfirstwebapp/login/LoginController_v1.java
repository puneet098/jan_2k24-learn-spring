package com.example.demo.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController_v1 {

	private Logger logger = LoggerFactory.getLogger(getClass());
	//login
	@RequestMapping("login_v1")//if you replace this @GetMapping, error page will be displayed
	public String sayHelloJsp(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		logger.debug("Request Param is {}",name);
		return "login_v1";
	}
}
