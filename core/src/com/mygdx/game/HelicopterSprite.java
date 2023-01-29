package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector3;
public class HelicopterSprite {
    private Texture helicopter;
    private Sprite newHelicopter;
    private Vector3 position;

    public HelicopterSprite(int x, int y) {
        position = new Vector3(x, y, 0f);
        helicopter = new Texture("attackhelicopter.png");
        newHelicopter = new Sprite(helicopter);
    }

    public Texture getHelicopter() {
        return helicopter;
    }

    public Sprite getNewHelicopter() {
        return newHelicopter;
    }

    public Vector3 getPosition() {
        return position;
    }

}