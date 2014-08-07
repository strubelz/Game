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
import com.badlogic.gdx.math.MathUtils;
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
	int x_j = 0;
	int y_j = 0;
	static ArrayList<Task> tasklist = new ArrayList<Task>();
	Vector2 v1;
	Vector2 v2;
	Vector2 v3;
	Vector2 v4;
	Vector2 v5;
	Vector2 v6;
	Vector2 v7;
	Vector2 v8;
	
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
		StartScreen sc = new StartScreen(this);
		
		int i = Math.min(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		Vector2 vd = new Vector2(1, 0.000000001f);
		Vector2 vc = new Vector2(i/5, i/5*2);
		Vector2 vb = new Vector2(0, 1).rotate(-22.5f);
		Vector2 va = new Vector2(i/5, i/5);
		Vector2 ve = new Vector2(va.x - vc.x, va.y - vc.y);
		
		float s = (ve.x - ve.y*vd.x/vd.y) / (vb.y*vd.x/vd.y - vb.x);
		
		v1 = new Vector2(va.x + s * vb.x, va.y + s * vb.y);
		
		vd = new Vector2(0.0000000001f, 1);
		vc = new Vector2(i/5*2, i/5);
		vb = new Vector2(1, 0).rotate(22.5f);
		ve = new Vector2(va.x - vc.x, va.y - vc.y);
		
		s = (ve.x - ve.y*vd.x/vd.y) / (vb.y*vd.x/vd.y - vb.x);
		
		v2 = new Vector2(va.x + s * vb.x, va.y + s * vb.y);
		
		vd = new Vector2(0.0000001f, -1);
		vc = new Vector2(i/5*2, i/5);
		vb = new Vector2(1, 0).rotate(-22.5f);
		ve = new Vector2(va.x - vc.x, va.y - vc.y);
		
		s = (ve.x - ve.y*vd.x/vd.y) / (vb.y*vd.x/vd.y - vb.x);
		
		v3 = new Vector2(va.x + s * vb.x, va.y + s * vb.y);
		
		vd = new Vector2(1, 0.000000001f);
		vc = new Vector2(i/5, 0);
		vb = new Vector2(0, -1).rotate(22.5f);
		ve = new Vector2(va.x - vc.x, va.y - vc.y);
		
		s = (ve.x - ve.y*vd.x/vd.y) / (vb.y*vd.x/vd.y - vb.x);
		
		v4 = new Vector2(va.x + s * vb.x, va.y + s * vb.y);
		
		vd = new Vector2(-1, 0.000000001f);
		vc = new Vector2(i/5, 0);
		vb = new Vector2(0, -1).rotate(-22.5f);
		ve = new Vector2(va.x - vc.x, va.y - vc.y);
		
		s = (ve.x - ve.y*vd.x/vd.y) / (vb.y*vd.x/vd.y - vb.x);
		
		v5 = new Vector2(va.x + s * vb.x, va.y + s * vb.y);
		
		vd = new Vector2(0.0000000001f, -1);
		vc = new Vector2(0, i/5);
		vb = new Vector2(-1, 0).rotate(-22.5f);
		ve = new Vector2(va.x - vc.x, va.y - vc.y);
		
		s = (ve.x - ve.y*vd.x/vd.y) / (vb.y*vd.x/vd.y - vb.x);
		
		v6 = new Vector2(va.x + s * vb.x, va.y + s * vb.y);
		
		vd = new Vector2(0.00000001f, 1);
		vc = new Vector2(0, i/5);
		vb = new Vector2(1, 0).rotate(22.5f);
		ve = new Vector2(va.x - vc.x, va.y - vc.y);
		
		s = (ve.x - ve.y*vd.x/vd.y) / (vb.y*vd.x/vd.y - vb.x);
		
		v7 = new Vector2(va.x + s * vb.x, va.y + s * vb.y);
		
		vd = new Vector2(-1, 0.000000001f);
		vc = new Vector2(i/5, i/5*2);
		vb = new Vector2(0, 1).rotate(22.5f);
		ve = new Vector2(va.x - vc.x, va.y - vc.y);
		
		s = (ve.x - ve.y*vd.x/vd.y) / (vb.y*vd.x/vd.y - vb.x);
		
		v8 = new Vector2(va.x + s * vb.x, va.y + s * vb.y);
		
		screen = sc;
		this.setScreen(sc);
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
			double distance = Math.sqrt(Math.pow(i/5 - x, 2) + Math.pow(i/5 -(Gdx.graphics.getHeight() - y), 2));
			shape_renderer.setColor(Color.WHITE);
			
			double a = computeAngle(x_j, y_j, v8.x, v8.y, i/5, i/5) + computeAngle(x_j, y_j, i/5, i/5, v1.x, v1.y) + computeAngle(x_j, y_j, v8.x, v8.y, v1.x, v1.y);
			if ((int)a == 359) {
				pos.y += 4.5 * speed_multi;
			}
			
			a = computeAngle(x_j, y_j, v1.x, v1.y, i/5, i/5) + computeAngle(x_j, y_j, i/5, i/5, v2.x, v2.y) + computeAngle(x_j, y_j, v1.x, v1.y, v2.x, v2.y);
			if ((int)a == 359) {
				pos.y += 4.5 * speed_multi;
				pos.x += 4.5 * speed_multi;
			}
			
			a = computeAngle(x_j, y_j, v2.x, v2.y, i/5, i/5) + computeAngle(x_j, y_j, i/5, i/5, v3.x, v3.y) + computeAngle(x_j, y_j, v2.x, v2.y, v3.x, v3.y);
			if ((int)a == 359) {
				pos.x += 4.5 * speed_multi;
			}
			
			a = computeAngle(x_j, y_j, v3.x, v3.y, i/5, i/5) + computeAngle(x_j, y_j, i/5, i/5, v4.x, v4.y) + computeAngle(x_j, y_j, v3.x, v3.y, v4.x, v4.y);
			if ((int)a == 359) {
				pos.y -= 4.5 * speed_multi;
				pos.x += 4.5 * speed_multi;
			}
			
			a = computeAngle(x_j, y_j, v4.x, v4.y, i/5, i/5) + computeAngle(x_j, y_j, i/5, i/5, v5.x, v5.y) + computeAngle(x_j, y_j, v4.x, v4.y, v5.x, v5.y);
			if ((int)a == 359) {
				pos.y -= 4.5 * speed_multi;
			}
			
			a = computeAngle(x_j, y_j, v5.x, v5.y, i/5, i/5) + computeAngle(x_j, y_j, i/5, i/5, v6.x, v6.y) + computeAngle(x_j, y_j, v5.x, v5.y, v6.x, v6.y);
			if ((int)a == 359) {
				pos.y -= 4.5 * speed_multi;
				pos.x -= 4.5 * speed_multi;
			}
			
			a = computeAngle(x_j, y_j, v6.x, v6.y, i/5, i/5) + computeAngle(x_j, y_j, i/5, i/5, v7.x, v7.y) + computeAngle(x_j, y_j, v6.x, v6.y, v7.x, v7.y);
			if ((int)a == 359) {
				pos.x -= 4.5 * speed_multi;
			}
			
			a = computeAngle(x_j, y_j, v7.x, v7.y, i/5, i/5) + computeAngle(x_j, y_j, i/5, i/5, v8.x, v8.y) + computeAngle(x_j, y_j, v7.x, v7.y, v8.x, v8.y);
			if ((int)a == 359) {
				pos.y += 4.5 * speed_multi;
				pos.x -= 4.5 * speed_multi;
			}
			
			if (distance < i/5) {
				x_j = x;
				y_j = Gdx.graphics.getHeight() - y;;
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
			shape_renderer.line(i/5, i/5, v1.x, v1.y);
			shape_renderer.line(i/5, i/5, v2.x, v2.y);
			shape_renderer.line(i/5, i/5, v3.x, v3.y);
			shape_renderer.line(i/5, i/5, v4.x, v4.y);
			shape_renderer.line(i/5, i/5, v5.x, v5.y);
			shape_renderer.line(i/5, i/5, v6.x, v6.y);
			shape_renderer.line(i/5, i/5, v7.x, v7.y);
			shape_renderer.line(i/5, i/5, v8.x, v8.y);
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
	
	double computeAngle(float x1, float y1, float x2, float y2, float x3, float y3) {
		
		float[] a = new float[]{x1 - x2, y1 - y2};
		float[] b = new float[]{x1 - x3, y1 - y3};
		float ab = a[0]*b[0] + a[1]*b[1];
		double aa = Math.sqrt(Math.pow(a[0], 2) + Math.pow(a[1], 2));
		double bb = Math.sqrt(Math.pow(b[0], 2) + Math.pow(b[1], 2));
		double aabb = ab/(aa*bb);
		
		return Math.acos(aabb)*MathUtils.radiansToDegrees;
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
