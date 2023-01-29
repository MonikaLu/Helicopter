package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

//Inspirert av https://www.youtube.com/watch?v=G44YMwBoJXM&list=PLZm85UZQLd2TPXpUJfDEdWTSgszionbJy&index=13&ab_channel=BrentAureliCodes

public class Animation {
    public Array<TextureRegion> frames;
    float maxFrameTime, currentFrameTime;
    int frameCount, currentFrame;

    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth()/frameCount;
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i*frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        currentFrame = 0;

    }

    public Array<TextureRegion> getFrames() {
        return frames;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime) {
         currentFrame++;
         currentFrameTime = 0;
        }
        if (currentFrame >= frameCount) {
            currentFrame = 0;
        }
    }

    public TextureRegion getFrame() {
        return frames.get(currentFrame);
    }
}
