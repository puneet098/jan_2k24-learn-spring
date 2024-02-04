package com.example.rest.webservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}
	
	@GetMapping("/hello-world")
	public String helloworld() {
		return "Hello World";
	}

	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloworldbean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping(path="/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(
				String.format("Hello World %s", name));
	}
	
	@GetMapping("/hello-world-i18n")
	public String helloworldi18n() {	
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		
		//return "Hello World V2"; 
		
				//1:
				//2:
//				- Example: `en` - English (Good Morning)
//				- Example: `nl` - Dutch (Goedemorgen)
//				- Example: `fr` - French (Bonjour)
//				- Example: `de` - Deutsch (Guten Morgen)

			
	}

	
}
