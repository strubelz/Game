package com.strubel.game;

import java.util.Random;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class LevelTask extends Task {
	
	static int level = 1;
	static float level_time = 5;
	static int level_count = 0;
	Random rand = new Random();
	
	@Override
	public void run() {
		
		if (AGame.isrunning) {
		level_time = level_time * 1.1f;
		level_count = 0;
		level++;
			
		int i = this.randomNumber(1, 5);
		if (i == 1) {
			AGame.circle_size /= 1.1f;
		}
		if (i == 2) {
			AGame.circle_size /= 1.1f;
		}
		if (i == 3) {
			AGame.speed_multi *= 1.4f;
		}
		if (i == 4) {
			BasicTask.max /= 1.1;
		}
		if (i == 5) {
			AGame.circle_size /= 1.1f;
		}
			
		
		level_count++;
		
		Timer.schedule(this, level_time);
		
		}
		
	}
	
	int randomNumber(int min, int max) {
		return rand.nextInt((max - min) + 1) + min;
	}

}
