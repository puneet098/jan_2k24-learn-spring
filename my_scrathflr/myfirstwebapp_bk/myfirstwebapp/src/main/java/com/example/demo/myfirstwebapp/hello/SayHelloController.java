package com.example.demo.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	//"say-hello" => "Hello!What are you learning today?"
	
	//"Say-hello"
	@GetMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return"Hello!What are you learning today?";
	}
	
	/**
	 * Say hello with HTML in String Buffer
	 */
	@GetMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My First HTML Page </title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first HTML Page with body.");
		sb.append("</body>");
		sb.append("</html>");		
		return sb.toString();
	}
	
	// "say-hello-jsp" => sayHello.jsp 
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	

	@GetMapping("say-hello-jsp")
	//@ResponseBody
	public String sayHelloJsp() {
		return"sayHello";
	}
	
	@GetMapping("say-welcome-jsp")
	public String sayWwelcome() {
		return "sayWelcome";
	}
}
