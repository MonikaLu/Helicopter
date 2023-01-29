package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

//Inspirert av https://www.youtube.com/watch?v=WTcdgIkzBRk&ab_channel=BipedPotato
//og https://www.youtube.com/watch?v=gR88EZEXEQg&ab_channel=BrentAureliCodes

public class MyHelicopter extends State implements ApplicationListener {
	SpriteBatch batch;
	int direction = -1;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;

	int screenHeight = HEIGHT;
	int screenWidth = WIDTH;
	private HelicopterSprite helicopterSprite;

	@Override
	public void create ()
	{batch = new SpriteBatch();
	helicopterSprite = new HelicopterSprite(screenWidth/2, screenHeight/2);
	}
	@Override
	public void resize(int width, int height) {
		screenWidth = width;
		screenHeight = height;
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 1, 1);
		batch.begin();
		batch.draw(helicopterSprite.getNewHelicopter(), helicopterSprite.getPosition().x, helicopterSprite.getPosition().y,
				helicopterSprite.getNewHelicopter().getWidth(), helicopterSprite.getNewHelicopter().getHeight());
		batch.end();

		helicopterSprite.getPosition().x += direction * 200 * Gdx.graphics.getDeltaTime();
		if (helicopterSprite.getPosition().x >= screenWidth-helicopterSprite.getHelicopter().getWidth()) {
			direction = -1;
			helicopterSprite.getNewHelicopter().flip(true, false);
		}
		else if (helicopterSprite.getPosition().x < 0) {
			direction = 1;
			helicopterSprite.getNewHelicopter().flip(true, false);
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
