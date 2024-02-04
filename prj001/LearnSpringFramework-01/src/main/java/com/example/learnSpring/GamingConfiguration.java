package com.example.learnSpring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.learnSpring.game.GameRunner;
import com.example.learnSpring.game.GamingConsole;
import com.example.learnSpring.game.PacmanGame;

@Configuration
public class GamingConfiguration {

	@Bean
	public GamingConsole game() {
		var game = new PacmanGame();
		return game;
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) {		
		var gameRunner = new GameRunner(game);
		return gameRunner;
	}

}
