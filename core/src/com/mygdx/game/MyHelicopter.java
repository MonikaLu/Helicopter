package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyHelicopter extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("attackhelicopter.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		for (int i = 0; i < 100; i++) {
			batch.begin();
			batch.draw(img, i, i);
			batch.end();
		}

	}


	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
