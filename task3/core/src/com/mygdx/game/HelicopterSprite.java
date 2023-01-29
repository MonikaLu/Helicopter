package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
public class HelicopterSprite {
    private Vector3 position;
  Animation anim;

    public HelicopterSprite(int x, int y) {
        position = new Vector3(x, y, 0f);
        Texture texture = new Texture("sprites.png");
        anim = new Animation(new TextureRegion(texture), 4, 0.01f);
    }
    public TextureRegion getHelicopter() {
        return anim.getFrame();
    }


    public Vector3 getPosition() {
        return position;
    }

}