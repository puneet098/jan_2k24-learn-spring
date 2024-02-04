package com.example.learnSpring.examples.d1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA{
	
	
}

@Component
@Lazy
class ClassB{
	
	private ClassA classA;
	
	public ClassB(ClassA classA) {
		//Logic
		System.out.println("Some Initalization Logic");
		this.classA = classA;
	}
	
	public void doSomething() {
		System.out.println("Do Something");
	}
}

@Configuration
@ComponentScan
public class LazyInitializationSpringContextLauncherApplication {

	public static void main(String[] args) {
		
		try(var context = 
				new AnnotationConfigApplicationContext
				(LazyInitializationSpringContextLauncherApplication.class)){
		
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("Initialization of context is now completed.");
			context.getBean(ClassB.class).doSomething();
		}
		

	}

}
