package com.izzist.game.entity.Enemy;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.BombManager;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * class Enemy Minvo.
 */
public class Minvo extends Enemy {
    public Minvo(Vector2D position, int size) {
        super(position, size);
        this.xOffSet = 4;
        this.yOffSet = 2;
        dead_animation.setFrames(Sprite.minvo_dead);
        dead_animation.setDelay(20);
        setAnimation(RIGHT, Sprite.minvo_right, 10);
        rectangle = new Rectangle2D.Float(position.x + xOffSet,
                position.y + yOffSet, 24, 30);
        speed = 2f;
        chase = new Rectangle((int) rectangle.getX() - 120, (int) rectangle.getY() - 120,
                120 * 2 + (int) rectangle.getWidth(), 120 * 2 + (int) rectangle.getHeight());
    }

    @Override
    public void animate() {
        if (random == 0) {
            if (currentAnimation != UP) {
                setAnimation(UP, Sprite.minvo_right, 10);
            }
        } else if (random == 1) {
            if (currentAnimation != DOWN) {
                setAnimation(DOWN, Sprite.minvo_left, 10);
            }
        } else if (random == 2) {
            if (currentAnimation != LEFT) {
                setAnimation(LEFT, Sprite.minvo_left, 10);
            }
        } else if (random == 3) {
            if (currentAnimation != RIGHT) {
                setAnimation(RIGHT, Sprite.minvo_right, 10);
            }
        }
    }

    /**
     * update toc do khi duoi bomber.
     */
    public void updateSpeed() {
        if (chase.intersects(PlayState.player.getRectangle())) {
            speed = 2.5f;
        } else {
            speed = 2f;
        }
    }

    @Override
    public void moveCondition() {
        temp1 = (int) position.x;
        temp2 = (int) position.y;
        if (!collisionWall(dx, 0) && !collisionBrick(dx, 0)) {
            position.x += dx;
        }
        if (!collisionWall(0, dy) && !collisionBrick(0, dy)) {
            position.y += dy;
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        //g2D.drawRect((int) rectangle.getX(), (int) rectangle.getY(), (int) rectangle.getWidth(), (int) rectangle.getHeight());
        if (isAlive) {
            g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
            //g2D.drawRect(chase.x, chase.y, chase.width, chase.height);
        } else {
            g2D.drawImage(dead_animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        }
    }

    @Override
    public void update() {
        super.update();
        if (isAlive) {
            animate();
            animation.update();
            updateChase();
            move2();
            randomDirection();
            moveCondition();
            updateRect();
            updateSpeed();
            minvoSkill();
        } else {
            rectangle = new Rectangle();
            dead_animation.update();
        }

        if (flameCollision()) {
            isAlive = false;
        }
    }

    /**
     * va cham minvo.
     */
    public void minvoSkill() {
        if (BombManager.bombs != null) {
            for (Bomb b : BombManager.bombs) {
                if (rectangle.intersects(b.getRectangle())) {
                    b.setExplodeTime(0);
                }
            }
        }
    }

    /**
     * update vung duoi bomber.
     */
    public void updateChase() {
        chase.setLocation((int) rectangle.getX() - 120, (int) rectangle.getY() - 120);
    }
}
