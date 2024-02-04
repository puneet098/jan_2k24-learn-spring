package com.example.learnSpring.game;

public class GameRunner {
	
	//MarioGame game;
	//private superContraGame game;
	private GamingConsole game;

	public GameRunner(GamingConsole game) {
	
		this.game = game;
	}

	public void run() {
		
		System.out.println("Running game"+game);
		
		game.up();
		game.down();
		game.left();
		game.right();
		
	}
	
	

}
