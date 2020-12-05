package com.izzist.game.entity.Enemy;

import com.izzist.game.entity.Character;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.Random;

public abstract class Enemy extends Character {
    protected int random;
    protected float random2;
    protected int randomSpeed = 150;
    protected Rectangle chase;
    protected int temp1;
    protected int temp2;
    protected int temp3;
    protected int temp4;
    protected int thinkSpeed = 20;


    public Enemy(Vector2D position, int size) {
        this.position = position;
        this.size = size;
        this.sprite = new Sprite();
        dead_animation = new Animation();
        animation = new Animation();
    }

    public void moveCondition() {
        temp1 = (int) position.x;
        temp2 = (int) position.y;
        if (!collisionWall(dx, 0) && !collisionBrick(dx, 0) && !collisionBomb(dx, 0)) {
            position.x += dx;
        }
        if (!collisionWall(0, dy) && !collisionBrick(0, dy) && !collisionBomb(0, dy)) {
            position.y += dy;
        }
    }


    public void moveCondition2() {
        temp3 = (int) position.x;
        temp4 = (int) position.y;
        if (!collisionWall(dx, 0) && !collisionBomb(dx, 0)) {
            position.x += dx;
        }
        if (!collisionWall(0, dy) && !collisionBomb(0, dy)) {
            position.y += dy;
        }
    }

    public void moveCondition3() {
        temp1 = (int) position.x;
        temp2 = (int) position.y;
        if (!collisionWall(dx, 0) && !collisionBrick(dx, 0) ) {
            position.x += dx;
        }
        if (!collisionWall(0, dy) && !collisionBrick(0, dy) ) {
            position.y += dy;
        }
    }

    public void randomDirection() {
        if (randomSpeed > 0) {
            randomSpeed--;
        } else {
            random2 = new Random().nextFloat() + 0.5f;
            randomSpeed = 150;
        }

        if (thinkSpeed > 0) {
            thinkSpeed--;
        } else if (temp1 == (int) position.x && temp2 == (int) position.y && thinkSpeed == 0) {
            random = new Random().nextInt(4);
            thinkSpeed = 20;
        }
    }

    public void randomDirection2() {
        if (thinkSpeed > 0) {
            thinkSpeed--;
        } else if (temp3 == (int) position.x && temp4 == (int) position.y && thinkSpeed == 0) {
            random = new Random().nextInt(4);
            thinkSpeed = 20;
        }
    }

    public void move() {
        if (random == 0) {
            dy = -speed;
        }
        if (random == 1) {
            dy = speed;
        }
        if (random == 2) {
            dx = -speed;
        }
        if (random == 3) {
            dx = speed;
        }
    }

    public void move2() {
        if (!chase.intersects(PlayState.player.getRectangle())) {
            move();
        } else {
            if (position.y > PlayState.player.getPosition().y + 1) {
                dy = -speed;
            }
            if (position.y < PlayState.player.getPosition().y - 1) {
                dy = speed;
            }
            if (position.x > PlayState.player.getPosition().x + 1) {
                dx = -speed;
            }
            if (position.x < PlayState.player.getPosition().x - 1) {
                dx = speed;
            }
        }
    }

    public void updateChase() {
        chase.setLocation((int) rectangle.getX() - 60, (int) rectangle.getY() - 60);
    }

}
