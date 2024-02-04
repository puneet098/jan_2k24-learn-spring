package com.example.learnSpring.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//Eliminate verbosity in creating Java Beans
//Public accessor methods, constructor,
//equals, hashcode and toString are automatically created.
//Released in JDK16.

//Person - Name, Age
record Person(String name, int age) {};

//Address - firstLine,city
record Address(String firstLine, String city) {};

//Person + Address
record PersonAddr(String name, int age, Address address) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		
		return "Puneet";
	}
	
	@Bean
	public int age() {
		return 43;
	}
	
	@Bean
	public Person person() {
		return new Person("Vineet", 40);
	}
	
	@Bean(name="usAddress")
	@Primary
	public Address address() {
		return new Address("High Street", "Ohio,U.S.");
	}
	
	//Qualifier Bean : Make one of the Primary
	//as usAddress is declared as primary
	@Bean(name="mumAdr")
	@Qualifier("mumAdrressQualifier")
	public Address address01() {
		return new Address("Runwal Forest", "Mumbai,MH");
	}

	//you can also create a bean by method call
	@Bean
	public Person personByMethodCall() {
		return new Person(name(), age());
	}
	
	//Person+Address
	@Bean
	public PersonAddr personAddr() {
		return new PersonAddr("Puneet Pandey", 43, address());
	}
	
	//Person Bean by passing parameters
	//way to call @Qualifier Bean.
	@Bean
	public PersonAddr personAddrByParameters(String name, int age, @Qualifier("mumAdrressQualifier") Address mumAdr) {
		return new PersonAddr(name, age, mumAdr);
	}
	

}
