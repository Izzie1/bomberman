package com.izzist.game.entity;

import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Player extends Entity {
    private final int UP = 3;
    private final int DOWN = 0;
    private final int RIGHT = 1;
    private final int LEFT = 2;
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;
    private boolean attack;
    private ArrayList<Bomb> b;
    private int numOfBomb;
    private boolean temp;
    private float dx;
    private float dy;
    private float maxSpeed = 2;
    private float acceleration = 0.1f;
    private float deAcceleration = 0.5f;
    private boolean setBomb;

    public Player(Vector2D vector2D, int size) {
        super(vector2D, size);
        this.sprite = new Sprite("font/bomberman 24x24 - Copy.png", 24, 24);

        animation = new Animation();
        setAnimation(DOWN, sprite.getSpriteArray(DOWN, 0), 5);

        b = new ArrayList<Bomb>();
        b.add(new Bomb(sprite, new Vector2D(position.x, position.y), 32));
        numOfBomb = 3;

    }

    public void animate() {
        if (up) {
            if (currentAnimation != UP || animation.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP, 0), 5);
            }
        } else if (down) {
            if (currentAnimation != DOWN || animation.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN, 0), 5);
            }
        } else if (left) {
            if (currentAnimation != LEFT || animation.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT, 0), 5);
            }
        } else if (right) {
            if (currentAnimation != RIGHT || animation.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT, 0), 5);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation, 0), -1);
        }
    }

    public void update() {
        animate();
        move();
        plantBomb();
        animation.update();
        position.x += dx;
        position.y += dy;
    }

    private void plantBomb(){
        if (attack && !setBomb) {
            b.get(0).setPosition((int) (position.x / 32) * 32, (int) (position.y / 32) * 32);
            setBomb = true;
        }
        b.get(0).update();
        if (b.get(0).getIsExploded()) {
            setBomb = false;
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.setColor(Color.BLUE);

        g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        if (setBomb && !b.get(0).getIsExploded()) {
            b.get(0).render(g2D);
            g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        }
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


    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public void setDeAcceleration(float deAcceleration) {
        this.deAcceleration = deAcceleration;
    }
}
