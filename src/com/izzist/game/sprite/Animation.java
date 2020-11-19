package com.izzist.game.sprite;

import java.awt.image.BufferedImage;

public class Animation {
    private int delay, index;
    private BufferedImage[] frames;
    private long timer, lastTime;

    public Animation(int delay, BufferedImage[] frames) {
        this.delay = delay;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    public void update() {
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();
        if (timer > delay) {
            index++;
            timer = 0;
            if (index >= frames.length) {
                index = 0;
            }
        }
    }

    public BufferedImage getCurrentFrame() {
        return frames[index];
    }

}
