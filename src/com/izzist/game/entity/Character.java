package com.izzist.game.Entity;

/**
 * Class danh cho cac doi tuong nhu enemy hay bomber.
 */
public abstract class Character extends Entity {
    protected boolean isAlive;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;

    protected float dx;
    protected float dy;
    protected float speed;
    protected float acceleration;
    protected float deAcceleration;

    public Character(float x, float y, int width, int height) {
        super(x, y, width, height);
        isAlive = true;
    }
}
