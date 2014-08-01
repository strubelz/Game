package com.strubel.game;

import java.util.ArrayList;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer.Task;

public class AGame extends Game implements InputProcessor {
	static SpriteBatch batch;
	ShapeRenderer shape_renderer;
	static BitmapFont font;
	static Vector2 pos;
	static float circle_size;
	static float circle_size_2;
	static float speed_multi = 1;
	static Screen screen;
	static boolean isrunning = true;
	FreeTypeFontGenerator font_gen;
	int x = 0;
	int y = 0;
	Vector2 last_pos = new Vector2(0, 0);
	static ArrayList<Task> tasklist = new ArrayList<Task>();
	
	@SuppressWarnings("deprecation")
	@Override
	public void create () {
		batch = new SpriteBatch();
		shape_renderer = new ShapeRenderer();
		pos = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		circle_size = Math.min(Gdx.graphics.getWidth(), Gdx.graphics.getHeight())/3f;
		circle_size_2 = Math.min(Gdx.graphics.getWidth(), Gdx.graphics.getHeight())/14f;
		font_gen = new FreeTypeFontGenerator(Gdx.files.internal("bebas.ttf"));
		font = font_gen.generateFont(20);
        font.setColor(Color.RED); 
		StartScreen s = new StartScreen(this);
		
		screen = s;
		this.setScreen(s);
	}

	@Override
	public void render () {
		x = Gdx.input.getX();
		y = Gdx.input.getY();
		screen = this.getScreen();
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glEnable(GL20.GL_BLEND);
	    Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	    Gdx.gl.glLineWidth(3);
		
		if (this.getScreen() == null) {
		
		if (Gdx.input.isKeyPressed(Keys.A))
			pos.x -= 4.5f * speed_multi;
		if (Gdx.input.isKeyPressed(Keys.S))
			pos.y -= 4.5f * speed_multi;
		if (Gdx.input.isKeyPressed(Keys.D))
			pos.x += 4.5f * speed_multi;
		if (Gdx.input.isKeyPressed(Keys.W))
			pos.y += 4.5f * speed_multi;
		
		batch.begin();
		font.draw(batch, "Level: " + LevelTask.level, 0, Gdx.graphics.getHeight()-20);
		font.draw(batch, "Seconds: " + TimeTask.seconds, 0, Gdx.graphics.getHeight()-20-font.getBounds("A").height);
		batch.end();
		
		shape_renderer.begin(ShapeType.Filled);
		
		shape_renderer.setColor(Color.RED);
		shape_renderer.circle(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, circle_size, 100);
		
		shape_renderer.setColor(Color.WHITE);
		shape_renderer.circle(pos.x, pos.y, circle_size_2, 100);
		
		if (Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS) {
			int i = Math.min(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			double distance = Math.sqrt(Math.pow(Math.max(i/5, x) - Math.min(i/5, x), 2) + Math.pow(Math.max(i/5, Gdx.graphics.getHeight() - y) - Math.min(i/5, Gdx.graphics.getHeight() - y), 2));
			shape_renderer.setColor(Color.WHITE);
			
			if (Gdx.graphics.getHeight() - y > i/5) {
				pos.y += 3.7 * speed_multi;
			}
			if (Gdx.graphics.getHeight() - y < i/5) {
				pos.y -= 3.7 * speed_multi;
			}
			if (x > i/5) {
				pos.x += 3.7 * speed_multi;
			}
			if (x < i/5) {
				pos.x -= 3.7 * speed_multi;
			}
			
			if (distance < i/5) {
				last_pos.x = x;
				last_pos.y = Gdx.graphics.getHeight() - y;
				shape_renderer.circle(x, Gdx.graphics.getHeight() - y, i/12, 100);
				
			}else {
				shape_renderer.circle(last_pos.x, last_pos.y, i/12, 100);
				
			}
			
		}
		
		shape_renderer.end();
		
		if (Gdx.app.getType() == ApplicationType.Android || Gdx.app.getType() == ApplicationType.iOS) {
			int i = Math.min(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			shape_renderer.begin(ShapeType.Line);
			shape_renderer.setColor(Color.WHITE);
			shape_renderer.circle(i/5, i/5, i/5, 100);
			shape_renderer.end();
		
		}
		}
		
		super.render();
	}
	
	@Override
	public void dispose() {
		font.dispose();
		shape_renderer.dispose();
		font_gen.dispose();
		batch.dispose();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
//		x = screenX;
//		y = screenY;
		
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		x = screenX;
		y = screenY;
		
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	static void killTasks() {
		
		for (Task t : tasklist) {
			t.cancel();
		}
		
		tasklist.clear();
		
	}
	
}
