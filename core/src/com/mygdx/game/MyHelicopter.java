package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

//Inspirert av https://www.youtube.com/watch?v=WTcdgIkzBRk&ab_channel=BipedPotato
//og https://www.youtube.com/watch?v=gR88EZEXEQg&ab_channel=BrentAureliCodes

public class MyHelicopter extends State implements ApplicationListener {
	SpriteBatch batch;

	BitmapFont font;

	public static int WIDTH = 480;
	public static  int HEIGHT = 800;

	int screenHeight = HEIGHT;
	int screenWidth = WIDTH;

	private HelicopterSprite helicopterSprite;
	//OrthographicCamera camera;
	//ExtendViewport vp;

	@Override
	public void create ()
	{
		//camera = new OrthographicCamera();
		//vp = new ExtendViewport(1080, 2214, camera);
		batch = new SpriteBatch();
	helicopterSprite = new HelicopterSprite(screenWidth/2, screenHeight/2);
	font = new BitmapFont();
	font.setColor(Color.BLACK);
	}
	@Override
	public void resize(int width, int height) {
	//vp.update(width, height);
	//batch.setProjectionMatrix(camera.combined);
	screenWidth = width;
	screenHeight = height;
	}
// Task 2a
	@Override
	public void handleInput() {
		if (Gdx.input.justTouched()) {
			helicopterSprite.getPosition().x = Gdx.input.getX() - (helicopterSprite.getHelicopter().getWidth()/2);
			helicopterSprite.getPosition().y = screenHeight - (Gdx.input.getY() + helicopterSprite.getHelicopter().getHeight()/2);
		/*	if (Gdx.input.getX() > (helicopterSprite.getHelicopter().getWidth()/2) && Gdx.input.getX() < screenWidth - (helicopterSprite.getHelicopter().getWidth()/2)){
				if (Gdx.input.getY() >= helicopterSprite.getHelicopter().getHeight( )|| Gdx.input.getY() < screenHeight - helicopterSprite.getHelicopter().getHeight()) {
					helicopterSprite.getPosition().y = screenHeight - (Gdx.input.getY() +( helicopterSprite.getHelicopter().getHeight() / 2));
					helicopterSprite.getPosition().x = (Gdx.input.getX() - (helicopterSprite.getHelicopter().getWidth()/2));
				}
			}*/
		}
		}


	@Override
	public void render () {
		ScreenUtils.clear(0, 1, 1, 1);

		batch.begin();
		handleInput();
		batch.draw(helicopterSprite.getHelicopter(), helicopterSprite.getPosition().x, helicopterSprite.getPosition().y, 420, 200);
		font.draw(batch, "Sprite Position: " + helicopterSprite.getPosition().x + ", " + helicopterSprite.getPosition().y ,
				20, screenHeight-100);
		font.getData().setScale(3, 3);
		batch.end();
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
