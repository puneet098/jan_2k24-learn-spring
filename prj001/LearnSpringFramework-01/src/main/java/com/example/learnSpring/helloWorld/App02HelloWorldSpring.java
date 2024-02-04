package com.example.learnSpring.helloWorld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		//1: Launch a Spring Context
		try(var context =
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)){
			
			//2: Configure the things that we want Spring to manage  
			// HelloWorldConfiguration - @Configuration
			//name - @Bean		
			System.out.println(context.getBean("name"));
			
			System.out.println(context.getBean("age"));
			
			System.out.println(context.getBean("person"));
			//1: - you can use name of the bean
			System.out.println(context.getBean("usAddress"));
			
			//2: - you can also use the type
			System.out.println(context.getBean(Address.class));
			
			//3: - you can call method call Bean
			System.out.println(context.getBean("personByMethodCall"));
			
			//4: - Person+Address
			System.out.println(context.getBean("personAddr"));
			
			//5: - Making Bean by Parameters
			System.out.println(context.getBean("personAddrByParameters"));
			
			//Bean Definition Count
			System.out.println("BeanDefinitionCount: "+context.getBeanDefinitionCount());
			
			//Bean Definition Names
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
		
			
		}
		
			
	}

}
