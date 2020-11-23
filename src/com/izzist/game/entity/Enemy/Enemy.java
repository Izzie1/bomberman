package com.izzist.game.entity.Enemy;

import com.izzist.game.entity.Character;
import com.izzist.game.states.PlayState;

import java.awt.*;
import java.util.Random;

public abstract class Enemy extends Character {
    protected int random;
    protected int randomSpeed = 200;

    public void moveCondition() {
        if (!collisionWall(dx, 0) && !collisionBrick(dx, 0) && !collisionBomb(dx, 0)) {
            position.x += dx;
        }
        if (!collisionWall(0, dy) && !collisionBrick(0, dy) && !collisionBomb(0, dy)) {
            position.y += dy;
        }
    }

    public void randomDirection() {
        if (randomSpeed > 0) {
            randomSpeed--;
        } else {
            random = new Random().nextInt(4);
            randomSpeed = 200;
        }
    }


}
