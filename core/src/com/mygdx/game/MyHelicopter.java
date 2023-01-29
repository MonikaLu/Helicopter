package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

//Inspirert av https://www.youtube.com/watch?v=WTcdgIkzBRk&ab_channel=BipedPotato
//og https://www.youtube.com/watch?v=gR88EZEXEQg&ab_channel=BrentAureliCodes

public class MyHelicopter extends State implements ApplicationListener {
	SpriteBatch batch;

	BitmapFont font;

	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	private HelicopterSprite helicopterSprite;


	@Override
	public void create ()
	{batch = new SpriteBatch();
	helicopterSprite = new HelicopterSprite(100, 400);
	font = new BitmapFont();
	font.setColor(Color.BLACK);
	}
	@Override
	public void resize(int width, int height) {

	}
// Task 2a
	@Override
	public void handleInput() {
		if (Gdx.input.justTouched()) {
			if (Gdx.input.getX() > (helicopterSprite.getHelicopter().getWidth()/2) && Gdx.input.getX() < WIDTH - (helicopterSprite.getHelicopter().getWidth()/2)){
				if (Gdx.input.getY() >= helicopterSprite.getHelicopter().getHeight( )|| Gdx.input.getY() < HEIGHT - helicopterSprite.getHelicopter().getHeight()) {
					helicopterSprite.getPosition().y = HEIGHT - (Gdx.input.getY() +( helicopterSprite.getHelicopter().getHeight() / 2));
					helicopterSprite.getPosition().x = (Gdx.input.getX() - (helicopterSprite.getHelicopter().getWidth()/2));
				}
			}
		}
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		batch.begin();
		batch.draw(helicopterSprite.getNewHelicopter(), helicopterSprite.getPosition().x, helicopterSprite.getPosition().y);
		font.draw(batch, "Sprite Position: " + helicopterSprite.getPosition().x + ", " + helicopterSprite.getPosition().y ,
				30, 770);


		batch.end();

		handleInput();
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
		font.dispose();
	}
}
