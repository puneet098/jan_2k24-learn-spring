package com.example.learnSpring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.learnSpring.game.GameRunner;
import com.example.learnSpring.game.GamingConsole;


@Configuration
@ComponentScan("com.example.learnSpring.game")
public class GamingAppLaucherApplication {

	public static void main(String [] args) {
		try(var context = new AnnotationConfigApplicationContext(GamingAppLaucherApplication.class)){
			
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
	}

}
