package com.izzist.game.entity;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.TileManager;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.AABB;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Player extends Character {
    private final int UP = 3;
    private final int DOWN = 0;
    private final int RIGHT = 1;
    private final int LEFT = 2;

    private boolean attack;
    private ArrayList<Bomb> bombs = new ArrayList<>();
    private int bombQuantity = 3;


    public Player(Vector2D position, int size) {
        this.position = position;
        this.size = size;
        this.sprite = new Sprite("font/bomberman 24x24 - Copy.png", 24, 24);
        animation = new Animation();
        setAnimation(DOWN, sprite.getSpriteArray(DOWN, 0), 5);
        maxSpeed = 2;
        acceleration = 0.1f;
        deAcceleration = 0.5f;
        bounds = new AABB(16, 20, position, 8, 4);
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
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation, 0), 5);
        }
    }

    public void update() {
        animate();
        move();
        animation.update();
        if (!collision(dx, 0)) {
            position.x += dx;
        }

        if (!collision(0, dy)) {
            position.y += dy;
        }
        setBomb();
        updateBomb();
        removeBomb();
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.setColor(Color.BLUE);
        g2D.drawRect((int) bounds.position.x + bounds.getxOffset()
                , (int) bounds.position.y + bounds.getyOffset(), 16, 20);
        g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
    }

    public void setBomb() {
        if (attack && bombs.size() < bombQuantity) {
            float x = this.position.x;
            float y = this.position.y;
            bombs.add(new Bomb(new Vector2D(x, y), 32));
        }
    }

    public void removeBomb() {
        for(int i = bombs.size()-1;i>=0;i--){
            if(bombs.get(i).getIsExploded()){
                Flame f = new Flame(bombs.get(i).getPosition(), 32);
                PlayState.flames.add(f);
                bombs.remove(i);
            }
        }
    }

    public void updateBomb() {
        for (Bomb bomb : bombs) {
            bomb.update();
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
        key.attack.tick();
        if (key.attack.clicked) {
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

    public ArrayList<Bomb> getBombs() {
        return bombs;
    }


}
