package com.izzist.game.entity.Enemy;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.EnemyManager;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Doll extends Enemy{

    public Doll(Vector2D position, int size) {
        super(position,size);
        this.xOffSet = 4;
        this.yOffSet = 2;
        dead_animation.setFrames(Sprite.oneal_dead);
        dead_animation.setDelay(20);
        setAnimation(RIGHT, Sprite.oneal_right, 10);
        rectangle = new Rectangle2D.Float( position.x + xOffSet,
                position.y + yOffSet, 24, 30);
        speed = 0.5f;
    }

    public void dollMoveLogic() {
        if (collisionWall(dx, 0) && collisionBrick(dx, 0) && collisionBomb(dx, 0)) {
            position.x -= dx * 2;
        }
        if (collisionWall(0, dy) && collisionBrick(0, dy) && collisionBomb(0, dy)) {
            position.y -= dy * 2;
        }
    }

    public void animate() {
        if (random == 0) {
            if (currentAnimation != UP) {
                setAnimation(UP, Sprite.doll_right, 10);
            }
        } else if (random == 1) {
            if (currentAnimation != DOWN) {
                setAnimation(DOWN, Sprite.doll_left, 10);
            }
        } else if (random == 2) {
            if (currentAnimation != LEFT) {
                setAnimation(LEFT, Sprite.doll_left, 10);
            }
        } else if (random == 3) {
            if (currentAnimation != RIGHT) {
                setAnimation(RIGHT, Sprite.doll_right, 10);
            }
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawRect((int)rectangle.getX(),(int)rectangle.getY(),(int)rectangle.getWidth(),(int)rectangle.getHeight());
        if (isAlive) {
            g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        } else {
            g2D.drawImage(dead_animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        }
    }

    @Override
    public void update() {
        if (isAlive) {
            animate();
            animation.update();
            randomDirection();
            updateRect();
            move();
            moveCondition();
            dollMoveLogic();
        } else {
            rectangle = new Rectangle();
            dead_animation.update();
        }

        if (flameCollision()) {
            isAlive = false;
        }
    }
}
