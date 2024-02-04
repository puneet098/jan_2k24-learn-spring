package com.example.learnSpring.examples.g1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BusinessService{
	private DataService dataService;


	public DataService getDataService() {
		return dataService;
	}
	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Settter Injection will be performed.");
		this.dataService = dataService;	
	}
}

//@Component
@Named
class DataService{
	
}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)){
		
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			context.getBean(BusinessService.class).getDataService();
		}
	}

}
