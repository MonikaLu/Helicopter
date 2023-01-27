package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyHelicopter extends State implements ApplicationListener {
	SpriteBatch batch;
	int direction = 1;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	private HelicopterSprite helicopterSprite;

	@Override
	public void create () {
		batch = new SpriteBatch();
	helicopterSprite = new HelicopterSprite(100, 100);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(helicopterSprite.getHelicopter(), helicopterSprite.getPosition().x, helicopterSprite.getPosition().y);
		batch.end();

		helicopterSprite.getPosition().x += direction * 200 * Gdx.graphics.getDeltaTime();
		if (helicopterSprite.getPosition().x >= WIDTH-helicopterSprite.getHelicopter().getWidth()) {
			direction = -1;
		}
		if (helicopterSprite.getPosition().x < 1) {
			direction = 1;
		}
	}


	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}



	@Override
	public void dispose () {
		batch.dispose();
	}
}
