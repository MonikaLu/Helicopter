package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
public class HelicopterSprite {
    private Texture helicopter;
    private Vector3 position;

    public HelicopterSprite(int x, int y) {
        position = new Vector3(x, y, 0f);
        helicopter = new Texture("attackhelicopter.png");
    }

    public Texture getHelicopter() {
        return helicopter;
    }

    public Vector3 getPosition() {
        return position;
    }

}