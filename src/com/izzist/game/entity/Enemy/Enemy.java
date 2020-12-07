package com.izzist.game.entity.Enemy;

import com.izzist.game.entity.Character;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.AudioPlayer;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.Random;

/**
 * Lop truu tuong Enemy.
 */
public abstract class Enemy extends Character {
    protected int random;
    protected int random2;
    protected int randomSpeed = 150;
    protected Rectangle chase;
    protected int temp1;
    protected int temp2;
    protected int thinkSpeed = 20;
    protected AudioPlayer dead;
    protected int playOnce = 1;
    /**
     * khoi tao.
     * @param position vi tri
     * @param size     do lon sprite
     */
    public Enemy(Vector2D position, int size) {
        this.position = position;
        this.size = size;
        this.sprite = new Sprite();
        dead_animation = new Animation();
        animation = new Animation();
        dead = new AudioPlayer("/sound/monster_die.mp3");
    }

    public void update(){
        if(!isAlive){
            playOnce--;
        }
        if(playOnce==0){
            dead.play();
        }
    }

    /**
     * check va cham tiles va bomb.
     */
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

    /**
     * random huong di enemy.
     */
    public void randomDirection() {
        if (thinkSpeed > 0) {
            thinkSpeed--;
        } else if (temp1 == (int) position.x && temp2 == (int) position.y && thinkSpeed == 0) {
            random = new Random().nextInt(4);
            thinkSpeed = 20;
        }
    }

    /**
     * di chuyen random cho enemy.
     */
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

    /**
     * di chuyen duoi bomber khi bomber lai gan.
     */
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

    /**
     * update vung duoi cho enemy.
     */
    public void updateChase() {
        chase.setLocation((int) rectangle.getX() - 60, (int) rectangle.getY() - 60);
    }

}
