package com.example.learnSpring;

import com.example.learnSpring.game.GameRunner;
import com.example.learnSpring.game.PacmanGame;

public class App01GamingBasic {

	public static void main(String[] args) {
		
		//var game = new MarioGame();
		//var game = new superContraGame();
		var game = new PacmanGame();//1 : Object Creation
		
		var gameRunner = new GameRunner(game);
			//2: Object Creation + wiring of dependencies
			//Game is dependencies.
		
		gameRunner.run();

	}

}
