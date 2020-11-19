package com.izzist.game.Entity;

import com.izzist.game.Game;

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


    public Character(float x, float y, int width, int height, Game game) {
        super(x, y, width, height, game);
        isAlive = true;
    }
}
