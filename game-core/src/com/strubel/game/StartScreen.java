package com.strubel.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class StartScreen implements Screen, InputProcessor {
	
    private SpriteBatch batch;
	private Game game;
    Texture tex;
    Texture tex2;
    Sprite s;
	
    public StartScreen(Game g) {
        game = g; 
        batch = new SpriteBatch();
        tex = new Texture(Gdx.files.internal("text.png"));
        tex2 = new Texture(Gdx.files.internal("text_clicked.png"));
        s = new Sprite(tex);
        s.setPosition(Gdx.graphics.getWidth()/2 - s.getWidth()/2, Gdx.graphics.getHeight()/4*3);
        Gdx.input.setInputProcessor(this);
    }

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		s.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
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
		if (AGame.screen != null && AGame.screen instanceof StartScreen) {
			
			if (screenX >= s.getX() && screenX <= s.getX() + s.getWidth() && Gdx.graphics.getHeight() -  screenY >= s.getY() && Gdx.graphics.getHeight() -  screenY <= s.getY() + s.getHeight()) {
				s = new Sprite(tex2);
		        s.setPosition(Gdx.graphics.getWidth()/2 - s.getWidth()/2, Gdx.graphics.getHeight()/4*3);
			}
			
		}
		
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		if (AGame.screen != null && AGame.screen instanceof StartScreen) {
			
			if (screenX >= s.getX() && screenX <= s.getX() + s.getWidth() && Gdx.graphics.getHeight() -  screenY >= s.getY() && Gdx.graphics.getHeight() -  screenY <= s.getY() + s.getHeight()) {
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
			}else {
				s = new Sprite(tex);
		        s.setPosition(Gdx.graphics.getWidth()/2 - s.getWidth()/2, Gdx.graphics.getHeight()/4*3);
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
