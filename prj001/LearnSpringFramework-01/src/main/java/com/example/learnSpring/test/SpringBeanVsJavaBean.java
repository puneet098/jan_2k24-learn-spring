package com.example.learnSpring.test;

import java.io.Serializable;

class Pojo{
	private String text;
	
	private int number;

	@Override
	public String toString() {
		return "Pojo [text=" + text + ", number=" + number + "]";
	}
	
	
}

class JavaBean implements Serializable{//EJB

	//public no-args constructor
	public JavaBean() {
	}
	
	private String text;

	private int number;

	//Getters and Setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}	
	
}

public class SpringBeanVsJavaBean {

	public static void main(String[] args) {
		
		Pojo pojo = new Pojo();
		
		System.out.println(pojo);

	}

}
