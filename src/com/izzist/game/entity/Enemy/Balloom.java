package com.izzist.game.entity.Enemy;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.entity.Item.ItemBomb;
import com.izzist.game.entity.Item.ItemFlame;
import com.izzist.game.entity.Item.ItemSpeed;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.ItemManager;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.AABB;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Balloom extends Enemy {

    private boolean isAlive = true;
    private Rectangle rectangle;
    private int randomTime = 20;
    private int random;

    public Balloom(Vector2D position, int size) {
        this.position = position;
        this.size = size;
        this.sprite = new Sprite("font/Balloom2.png", 16, 16);
        animation = new Animation();

        setAnimation(1, sprite.getSpriteArray2(1), 5);
        speed = 2;
        acceleration = 0.1f;
        deAcceleration = 0.5f;
        bounds = new AABB(16, 24, this.position, 8, 4);
        rectangle = new Rectangle((int) bounds.position.x + bounds.getxOffset(),
                (int) bounds.position.y + bounds.getyOffset(), bounds.getWidth(), bounds.getHeight());
    }

    public void animate() {
        if (random==0) {
            setAnimation(0, sprite.getSpriteArray2(0), 5);

        } else if (random==1) {
            setAnimation(1, sprite.getSpriteArray2(1), 5);

        } else if (random==2) {
            setAnimation(1, sprite.getSpriteArray2(1), 5);

        } else if (random==3) {
            setAnimation(0, sprite.getSpriteArray2(0), 5);

        }
    }

    public void update() {

        if (randomTime > 0){
            randomTime--;
        } else {
            random = new Random().nextInt(4);
            randomTime = 20;
        }

        animate();
        move();
        animation.update();
        if (!collision(dx, 0)) {
            position.x += dx;
        }

        if (!collision(0, dy)) {
            position.y += dy;
        }
        updateRect();
        if (flameCollision()) {
            position.x = 32;
            position.y = 32;
            setAnimation(1, sprite.getSpriteArray2(1), 5);
        }
    }

    public boolean flameCollision() {
        if (PlayState.flames != null) {
            for (Flame f : PlayState.flames) {
                if (f.getRectangles() != null) {
                    for (Rectangle rect : f.getRectangles()) {
                        if (rectangle.intersects(rect)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }


    @Override
    public void render(Graphics2D g2D) {
        g2D.setColor(Color.BLUE);
        g2D.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
    }

    public void updateRect() {
        rectangle.setBounds((int) bounds.position.x + 8, (int) bounds.position.y + 4, bounds.getWidth(), bounds.getHeight());
    }

    public void move() {
        if (random==0) {
            dy -= speed;
        }
        if (random==1) {
            dy += speed;
        }
        if (random==2) {
            dx -= speed;
        }
        if (random==3) {
            dx += speed;
        }
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

}
