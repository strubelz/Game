package com.strubel.game;

import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class BasicTask extends Task {
	
	static int count = 0;
	static int time = 0;
	static int mov_x = 0;
	static int mov_y = 0;
	static int min = 40;
	static int max = 300;
	double distance = 0;
	Random rand = new Random();
	Game game;
	
	public BasicTask(Game g) {
		game = g;
	}

	@Override
	public void run() {
		
		if (AGame.isrunning) {
		
		if (count >= time) {
			time = this.randomNumber(min, max);
			count = 0;
			
			if (randomBoolean()) {
				if (randomBoolean()) {
					mov_x = 4;
				}else {
					mov_x = -4;
				}
				mov_y = this.randomNumber(-3, 3);
			}else {
				if (randomBoolean()) {
					mov_y = 4;
				}else {
					mov_y = -4;
				}
				mov_x = this.randomNumber(-3, 3);
			}
			
		}
		
		count++;
		
		AGame.pos.x += (mov_x * AGame.speed_multi);
		AGame.pos.y += (mov_y * AGame.speed_multi);
		
		distance = Math.sqrt(Math.pow(AGame.pos.x - Gdx.graphics.getWidth()/2, 2) + Math.pow(AGame.pos.y - Gdx.graphics.getHeight()/2, 2));
		
		if (distance > AGame.circle_size + AGame.circle_size_2) {
			AGame.isrunning = false;
			game.setScreen(new RestartScreen(game));
		}
		
			Timer.schedule(this, 0.005f);
		
		}
		
	}
	
	int randomNumber(int min, int max) {
		return rand.nextInt((max - min) + 1) + min;
	}
	
	boolean randomBoolean() {
		return randomNumber(0, 1) == 1;
	}
	
}
