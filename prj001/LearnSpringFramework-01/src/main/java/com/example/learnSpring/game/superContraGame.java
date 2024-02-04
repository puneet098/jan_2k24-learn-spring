package com.example.learnSpring.game;

public class superContraGame implements GamingConsole {
	
	public void up() {
		System.out.println("up");
	}
	
	public void down() {
		System.out.println("Sit Down");
	}
	
	public void left() {
		System.out.println("Go Back.");
	}
	
	public void right() {
		System.out.println("Shoot a bullet.");
	}

}
