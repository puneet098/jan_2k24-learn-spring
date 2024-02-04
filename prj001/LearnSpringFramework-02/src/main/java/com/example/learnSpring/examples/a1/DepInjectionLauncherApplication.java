package com.example.learnSpring.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Component
class YourBusinessClass{
	@Autowired
	Dependency1 dependency1;
	
	@Autowired
	Dependency2 dependency2;
	
	public String toString() {
		
		//Field Injection
		return "Using" + dependency1 + " and " + dependency2;
	}
}

@Component
class YourSetterBusinessClass{

	Dependency1 dependency1;

	Dependency2 dependency2;

	@Autowired
	public void setDependency1(Dependency1 dependency1) {
		this.dependency1 = dependency1;
	}

	@Autowired
	public void setDependency2(Dependency2 dependency2) {
		this.dependency2 = dependency2;
	}


	public String toString() {

		return "Using" + dependency1 + " and " + dependency2;
	}
	
}

@Component
class YourConstructorDI{
	
	Dependency1 dependency1;

	Dependency2 dependency2;

	//@Autowired//this is not mandatory
	public YourConstructorDI(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor DI - YourConstructorDI ");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
	
}


@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}


@Configuration
@ComponentScan
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class)){
		
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		
			System.out.println("Field Injecion: -  " + context.getBean(YourBusinessClass.class));
			
			System.out.println("Setter Injection: - "+context.getBean(YourSetterBusinessClass.class));
			
			System.out.println("Constructor Injection: - "+context.getBean(YourConstructorDI.class));
		
		}
	}

}
