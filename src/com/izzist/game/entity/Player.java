package com.izzist.game.entity;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.AABB;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class Player extends Entity {
    private final int UP = 3;
    private final int DOWN = 0;
    private final int RIGHT = 1;
    private final int LEFT = 2;

    public Player(Sprite sprite, Vector2D vector2D, int size) {
        super(sprite, vector2D, size);
        bounds = new AABB(vector2D, size, size);
        hitBounds = new AABB(new Vector2D(vector2D.x + (size / 2), vector2D.y), size, size);

        animation = new Animation();
        setAnimation(DOWN, sprite.getSpriteArray(DOWN,0), 5);
    }

    @Override
    public void animate() {
        if (up) {
            if (currentAnimation != UP || animation.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP,0), 5);
            }
        } else if (down) {
            if (currentAnimation != DOWN || animation.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN,0), 5);
            }
        } else if (left) {
            if (currentAnimation != LEFT || animation.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT,0), 5);
            }
        } else if (right) {
            if (currentAnimation != RIGHT || animation.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT,0), 5);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation,0),-1 );
        }
    }

    public void update() {
        super.update();
        move();
        vector2D.x += dx;
        vector2D.y += dy;
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(animation.getImage(),(int)(vector2D.x),(int)(vector2D.y),size,size,null);
    }

    public void move() {
        if (up) {
            dy -= acceleration;
            if (dy < -maxSpeed) {
                dy = -maxSpeed;
            }
        } else {
            if (dy < 0) {
                dy += deAcceleration;
                if (dy > 0) {
                    dy = 0;
                }
            }
        }
        if (down) {
            dy += acceleration;
            if (dy > maxSpeed) {
                dy = maxSpeed;
            }
        } else {
            if (dy > 0) {
                dy -= deAcceleration;
                if (dy < 0) {
                    dy = 0;
                }
            }
        }
        if (left) {
            dx -= acceleration;
            if (dx < -maxSpeed) {
                dx = -maxSpeed;
            }
        } else {
            if (dx < 0) {
                dx += deAcceleration;
                if (dx > 0) {
                    dx = 0;
                }
            }
        }
        if (right) {
            dx += acceleration;
            if (dx > maxSpeed) {
                dx = maxSpeed;
            }
        } else {
            if (dx > 0) {
                dx -= deAcceleration;
                if (dx < 0) {
                    dx = 0;
                }
            }
        }

    }

    public void input(KeyHandler key) {
        if (key.up.down) {
            up = true;
        } else {
            up = false;
        }
        if (key.down.down) {
            down = true;
        } else {
            down = false;
        }
        if (key.left.down) {
            left = true;
        } else {
            left = false;
        }
        if (key.right.down) {
            right = true;
        } else {
            right = false;
        }
        if (key.attack.down) {
            attack = true;
        } else {
            attack = false;
        }
    }
}
