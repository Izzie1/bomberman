package com.izzist.game.entity;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.AABB;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    protected int currentAnimation;

    protected Animation animation;
    protected Sprite sprite;
    protected Vector2D vector2D;
    protected int size;

    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;
    protected boolean attack;

    protected float dx;
    protected float dy;
    protected float maxSpeed = 2;
    protected float acceleration = 0.1f ;
    protected float deAcceleration = 0.5f;

    protected AABB hitBounds;
    protected AABB bounds;

    public Entity(Sprite sprite, Vector2D vector2D, int size) {
        this.sprite = sprite;
        this.vector2D = vector2D;
        this.size = size;

    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public void setDeAcceleration(float deAcceleration){
        this.deAcceleration = deAcceleration;
    }


    public int getSize() {
        return size;
    }

    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        animation.setFrames(frames);
        animation.setDelay(delay);
    }

    public abstract void animate();

    private void setHitBoxDirection() {
        if (up) {
            hitBounds.setyOffset(-size / 2);
            hitBounds.setxOffset(-size / 2);
        } else if (down) {
            hitBounds.setyOffset(size / 2);
            hitBounds.setxOffset(-size / 2);
        } else if (left) {
            hitBounds.setyOffset(size);
            hitBounds.setxOffset(0);
        } else if (right) {
            hitBounds.setxOffset(0);
            hitBounds.setyOffset(0);
        }
    }

    public abstract void render(Graphics2D g2D);

    public void input(KeyHandler key) {

    }

    public void update() {
        animate();
        setHitBoxDirection();
        animation.update();
    }


}
