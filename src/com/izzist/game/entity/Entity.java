package com.izzist.game.entity;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.image.BufferedImage;

public class Entity {
    private final int UP = 0;
    private final int DOWN = 1;
    private final int RIGHT = 2;
    private final int LEFT = 3;
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
    protected float maxSpeed;
    protected float acceleration;
    protected float deAcceleration;

    public Entity (Sprite sprite, Vector2D vector2D){
        this.sprite = sprite;
        this.vector2D = vector2D;
        this.size = size;

        animation = new Animation();
        setAnimation(RIGHT,sprite.getSpriteArray(RIGHT),10);
    }

    public void setAnimation(int i, BufferedImage[] frames,int delay){
        currentAnimation = i;
        animation.setFrames(frames);
        animation.setDelay(delay);
    }
}
