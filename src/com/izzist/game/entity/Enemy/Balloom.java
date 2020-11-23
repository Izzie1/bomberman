package com.izzist.game.entity.Enemy;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class Balloom extends Enemy {

    public Balloom(Vector2D position, int size) {
        this.position = position;
        this.size = size;
        this.xOffSet = 2;
        this.yOffSet = 2;
        this.sprite = new Sprite("font/Balloom2.png", 16, 16);
        dead_animation = new Animation();
        dead_animation.setFrames(sprite.getSpriteArray2(2));
        dead_animation.setDelay(10);
        animation = new Animation();
        setAnimation(0, sprite.getSpriteArray2(0), 5);
        rectangle = new Rectangle((int) position.x + xOffSet,
                (int) position.y + yOffSet, 28, 28);
        speed = 0.5f;
    }

    public void animate() {
        if (random == 0) {
            if (currentAnimation != 0) {
                setAnimation(0, sprite.getSpriteArray2(0), 10);
            }
        } else if (random == 1) {
            if (currentAnimation != 1) {
                setAnimation(1, sprite.getSpriteArray2(1), 10);
            }
        } else if (random == 2) {
            if (currentAnimation != 1) {
                setAnimation(1, sprite.getSpriteArray2(1), 10);
            }
        } else if (random == 3) {
            if (currentAnimation != 0) {
                setAnimation(0, sprite.getSpriteArray2(0), 10);
            }
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

    @Override
    public void render(Graphics2D g2D) {
        if (isAlive) {
            g2D.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
            g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        } else {
            g2D.drawImage(dead_animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        }
    }

    @Override
    public void update() {
        if (isAlive) {
            animation.update();
            move();
            animate();
            randomDirection();
            moveCondition();
            updateRect();
        } else {
            dead_animation.update();
        }


        if (flameCollision()) {
            isAlive = false;
        }
    }

    public void updateRect() {
        rectangle = new Rectangle((int) position.x + xOffSet,
                (int) position.y + yOffSet, 28, 28);
    }


}
