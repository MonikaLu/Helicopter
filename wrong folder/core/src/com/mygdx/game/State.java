package com.mygdx.game;

public abstract class State {
    public void update(float dt){};

    public abstract void handleInput();

    public void render(){};
    public void create(){};

    public void dispose(){};


}