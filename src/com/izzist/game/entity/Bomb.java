package com.izzist.game.entity;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class Bomb extends Entity {
    private int countDownTime;
    private int explodeTime;
    private boolean exploded = false;


    public Bomb(Sprite sprite, Vector2D vector2D, int size){
        super(sprite,vector2D,size);

    }

    @Override
    public void render(Graphics2D g2D) {

    }

    @Override
    public void update() {

    }
}
