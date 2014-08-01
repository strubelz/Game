package com.strubel.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;

public class RestartScreen implements Screen, InputProcessor {

    private SpriteBatch batch;
	private Game game;
    Texture tex;
    Texture tex2;
    Sprite s;
	
    public RestartScreen(Game g) {
    	AGame.killTasks();
        game = g; 
        batch = new SpriteBatch();
        tex = new Texture(Gdx.files.internal("restart_text.png"));
        tex2 = new Texture(Gdx.files.internal("restart_text_clicked.png"));
        s = new Sprite(tex);
        s.setPosition(Gdx.graphics.getWidth()/2 - s.getWidth()/2, 20);
        Gdx.input.setInputProcessor(this);
    }

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		s.draw(batch);
		AGame.font.setScale(2);
		AGame.font.draw(batch, "Game Over!", Gdx.graphics.getWidth()/2-AGame.font.getBounds("Game Over!").width/2, Gdx.graphics.getHeight()/4*3);
		AGame.font.setScale(1);
		AGame.font.draw(batch, "Level: " + LevelTask.level, Gdx.graphics.getWidth()/2-AGame.font.getBounds("Level: " + LevelTask.level).width/2, Gdx.graphics.getHeight()/4*3 - AGame.font.getBounds("Game Over!").height * 4);
		AGame.font.draw(batch, "Seconds: " + TimeTask.seconds, Gdx.graphics.getWidth()/2-AGame.font.getBounds("Seconds: " + TimeTask.seconds).width/2, Gdx.graphics.getHeight()/4*3 - AGame.font.getBounds("Game Over!").height * 4 - AGame.font.getBounds("Level: " + LevelTask.level).height * 1.5f);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		tex.dispose();
		tex2.dispose();
		batch.dispose();
		game.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		if (AGame.screen != null && AGame.screen instanceof RestartScreen) {
			
			if (screenX >= s.getX() && screenX <= s.getX() + s.getWidth() && Gdx.graphics.getHeight() -  screenY >= s.getY() && Gdx.graphics.getHeight() -  screenY <= s.getY() + s.getHeight()) {
				s = new Sprite(tex2);
		        s.setPosition(Gdx.graphics.getWidth()/2 - s.getWidth()/2, 20);
			}
			
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		if (AGame.screen != null && AGame.screen instanceof RestartScreen) {
			
			if (screenX >= s.getX() && screenX <= s.getX() + s.getWidth() && Gdx.graphics.getHeight() -  screenY >= s.getY() && Gdx.graphics.getHeight() -  screenY <= s.getY() + s.getHeight()) {
				AGame.circle_size = Math.min(Gdx.graphics.getWidth(), Gdx.graphics.getHeight())/2.5f;
				AGame.circle_size_2 = Math.min(Gdx.graphics.getWidth(), Gdx.graphics.getHeight())/10f;
				AGame.pos = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
				AGame.speed_multi = 1;
				BasicTask.count = 0;
				BasicTask.time = 0;
				BasicTask.mov_x = 0;
				BasicTask.mov_y = 0;
				LevelTask.level = 1;
				LevelTask.level_time = 5;
				LevelTask.level_count = 0;
				TimeTask.seconds = 0;
				game.setScreen(null);
				Gdx.input.setInputProcessor((InputProcessor) game);
				BasicTask bt = new BasicTask(game);
				LevelTask lt = new LevelTask();
				TimeTask tt = new TimeTask();
				AGame.tasklist.add(bt);
				AGame.tasklist.add(lt);
				AGame.tasklist.add(tt);
				Timer.schedule(bt, 0.005f);
				Timer.schedule(lt, 5);
				Timer.schedule(tt, 1);
				AGame.isrunning = true;
			}else {
				
				s = new Sprite(tex);
		        s.setPosition(Gdx.graphics.getWidth()/2 - s.getWidth()/2, 20);
				
			}
			
		}
		
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
