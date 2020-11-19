package com.izzist.game.Entity;


import com.izzist.game.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Class Entity.
 */
public abstract class Entity {
    protected float x; //Toa do x
    protected float y; //Toa do y
    protected int width;
    protected int height;
    protected Game game;
    protected Rectangle bounds;

    public Entity(float x, float y,int width,int height,Game game) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void update();

    public abstract void render(Graphics g);

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getBounds() {
        return bounds;
    }

}
