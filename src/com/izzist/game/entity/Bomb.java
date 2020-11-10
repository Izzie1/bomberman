package com.izzist.game.entity;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class Bomb extends Entity {
    private int explodeTime = 150;
    private boolean isExploded = false;
    private int delay = 15;
    private int i = 0;


    public Bomb(Sprite sprite, Vector2D vector2D, int size) {
        super(sprite, vector2D, size);
        this.sprite = new Sprite("font/BombGreen_16_16.png", 16, 16);
        animation = new Animation();
    }

    public void setIsExploded(boolean exploded) {
        this.isExploded = exploded;
    }

    public boolean getIsExploded() {
        return isExploded;
    }

    @Override
    public void render(Graphics2D g2D) {
        if (!isExploded) {
            g2D.drawImage(sprite.getSprite(i, 0), (int) (position.x), (int) (position.y), size, size, null);
            if (i < 6) {
                if (delay == 0) {
                    i++;
                    delay = 15;
                } else delay--;
            } else i = 0;
        }
    }

    @Override
    public void update() {

        if (explodeTime > 0) {
            isExploded = false;
            explodeTime--;
        } else if (explodeTime == 0) {
            isExploded = true;
            explodeTime = 150;
        }
    }

    public void setPosition(int x, int y) {
        position.x = x;
        position.y = y;
    }

    public int getExplodeTime() {
        return explodeTime;
    }

    public void setExplodeTime(int explodeTime) {
        this.explodeTime = explodeTime;
    }
}
