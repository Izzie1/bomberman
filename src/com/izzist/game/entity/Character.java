package com.izzist.game.entity;

import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.managers.TileManager;
import com.izzist.game.states.PlayState;

import java.awt.*;

public abstract class Character extends Entity {
    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;

    protected float dx;
    protected float dy;
    protected float speed;
    protected float acceleration;
    protected float deAcceleration;
    protected Rectangle rectangle;

    protected boolean isAlive = true;

    public boolean collision(float ax, float ay) {
        for (int c = 0; c < 4; c++) {
            int xt = (int) (((rectangle.x + ax) + (c % 2) * rectangle.width) / 32);
            int yt = (int) (((rectangle.y + ay) + (c / 2) * rectangle.height) / 32);
            if ((TileManager.tileManager[xt][yt] != null && TileManager.tileManager[xt][yt].isCollide(this)) ||
                    (TileManager.getBrick(xt, yt) != null && TileManager.getBrick(xt, yt).isCollide(this))) {
                return true;
            }
        }

        return false;
    }

    public boolean flameCollision() {
        if (PlayState.flames != null) {
            for (Flame f : PlayState.flames) {
                if (f.getRectangles() != null) {
                    for (Rectangle rect : f.getRectangles()) {
                        if (rectangle.intersects(rect)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
