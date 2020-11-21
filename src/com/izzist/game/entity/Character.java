package com.izzist.game.entity;

import com.izzist.game.managers.TileManager;

public abstract class Character extends Entity {
    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;

    protected float dx;
    protected float dy;
    protected float maxSpeed;
    protected float acceleration;
    protected float deAcceleration;

    private boolean isAlive;

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
}
