package com.example.learnSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.learnSpring.game.GameRunner;
import com.example.learnSpring.game.GamingConsole;
import com.example.learnSpring.game.PacmanGame;

public class App03GamingSpringBeans {

	public static void main(String [] args) {
		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}

}
