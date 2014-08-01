package com.strubel.game;

import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class TimeTask extends Task {
	
	static int seconds;

	@Override
	public void run() {
		
		if (AGame.isrunning) {
		seconds++;
		
			Timer.schedule(this, 1);
		
		}
		
	}

}
