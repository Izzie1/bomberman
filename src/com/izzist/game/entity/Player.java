package com.izzist.game.entity;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.entity.Enemy.Enemy;
import com.izzist.game.entity.Item.ItemBomb;
import com.izzist.game.entity.Item.ItemFlame;
import com.izzist.game.entity.Item.ItemSpeed;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.BombManager;
import com.izzist.game.managers.EnemyManager;
import com.izzist.game.managers.ItemManager;
import com.izzist.game.managers.Sound;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Character {

    private boolean attack;
    private int lives = 3;
    private ArrayList<Bomb> bombs = new ArrayList<>();

    private int maxSpeed = 4;
    private int maxBomb = 3;
    private int maxFlameRange = 4;

    private int bombQuantity = 1;
    private int flameRange = 1;

    private int spawnX;
    private int spawnY;

    private int respawnTime = 100;
    private boolean isInvincible = true;
    public Player(Vector2D position, int size) {

        this.sprite = new Sprite("assets/bomberman 24x24.png", 24, 24);
        this.xOffSet = 8;
        this.yOffSet = 4;
        this.position = position;
        this.size = size;
        dead_animation = new Animation();
        dead_animation.setFrames(Sprite.playerDead);
        dead_animation.setDelay(10);
        spawnX = (int) position.x;
        spawnY = (int) position.y;
        animation = new Animation();
        setAnimation(DOWN, sprite.getSpriteArray(DOWN, 0), 5);
        speed = 2;
        acceleration = 0.1f;
        deAcceleration = 0.5f;
        rectangle = new Rectangle2D.Float(position.x + xOffSet,
                position.y + yOffSet, 16, 24);
    }

    public void animate() {
        if (up) {
            if (currentAnimation != UP) {
                setAnimation(UP, sprite.getSpriteArray(UP, 0), 5);
            }
        } else if (down) {
            if (currentAnimation != DOWN) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN, 0), 5);
            }
        } else if (left) {
            if (currentAnimation != LEFT) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT, 0), 5);
            }
        } else if (right) {
            if (currentAnimation != RIGHT) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT, 0), 5);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation, 0), 5);
        }
    }

    public void update() {

        if ((flameCollision() || isKilled()) && !isInvincible) {
            isAlive = false;
        }
        updateRect();
        if (isAlive) {
            animate();
            move();
            animation.update();
            if (!collisionWall(dx, 0) && !collisionBrick(dx, 0) && !collisionBombPlayer(dx, 0)) {
                position.x += dx;
            }
            if (!collisionWall(0, dy) && !collisionBrick(0, dy) && !collisionBombPlayer(0, dy)) {
                position.y += dy;
            }
            setBomb();
            updateBomb();
            removeBomb();
            takeItem();
        } else {
            Sound.playBomberDie();
            dead_animation.update();
            if (dead_animation.playOnce()) {
                resetProperties();
                lives--;
                position.x = spawnX;
                position.y = spawnY;
                isAlive = true;
                isInvincible = true;
                setAnimation(DOWN, sprite.getSpriteArray(DOWN, 0), 5);
                dead_animation.setTimePlay(0);
            }
        }
        if (isInvincible) {
            respawnTime--;
        }
        if (respawnTime == 0) {
            respawnTime = 100;
            isInvincible = false;
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        if (isAlive) {
            g2D.setColor(Color.BLUE);
            g2D.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        } else {
            g2D.drawImage(dead_animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
        }
    }

    public void resetProperties(){
        speed = 2;
        acceleration = 0.1f;
        deAcceleration = 0.5f;
        bombQuantity = 1;
        flameRange = 1;
    }

    public boolean collisionBombPlayer(float ax, float ay) {
        if (BombManager.bombs != null) {
            for (Bomb b : BombManager.bombs) {
                if (collisionRect(ax, ay).intersects(b.getRectangle()) && !b.isAllowToPass()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isKilled() {
        if (EnemyManager.enemies != null) {
            for (Enemy e : EnemyManager.enemies) {
                if (rectangle.intersects(e.getRectangle())) {
                    return true;
                }
            }
        }
        return false;
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


    public void setBomb() {
        if (attack && bombs.size() < bombQuantity) {
            float x = this.position.x;
            float y = this.position.y;
            bombs.add(new Bomb(new Vector2D(x, y), 32));
        }
    }



    public void removeBomb() {
        for (int i = bombs.size() - 1; i >= 0; i--) {
            if (bombs.get(i).getIsExploded()) {
                Flame f = new Flame(bombs.get(i).getPosition(), 32, flameRange);
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
            if (dy < -speed) {
                dy = -speed;
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
            if (dy > speed) {
                dy = speed;
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
            if (dx < -speed) {
                dx = -speed;
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
            if (dx > speed) {
                dx = speed;
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

    public void takeItem() {
        int xt = (int) (position.x + 16) / 32;
        int yt = (int) (position.y + 16) / 32;
        if (ItemManager.getItem(xt, yt) instanceof ItemSpeed) {
            if (speed < maxSpeed) {
                speed += 1;
                acceleration += 0.1f;
                deAcceleration += 0.5f;
            }
            ItemManager.items.remove(ItemManager.getItem(xt, yt));
        }
        if (ItemManager.getItem(xt, yt) instanceof ItemBomb) {
            if (bombQuantity < maxBomb) {
                bombQuantity += 1;
            }
            ItemManager.items.remove(ItemManager.getItem(xt, yt));
        }
        if (ItemManager.getItem(xt, yt) instanceof ItemFlame) {
            if (flameRange < maxFlameRange) {
                flameRange += 1;
            }
            ItemManager.items.remove(ItemManager.getItem(xt, yt));
        }
    }


    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.speed = maxSpeed;
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

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getSpawnX() {
        return spawnX;
    }

    public void setSpawnX(int spawnX) {
        this.spawnX = spawnX;
    }

    public int getSpawnY() {
        return spawnY;
    }

    public void setSpawnY(int spawnY) {
        this.spawnY = spawnY;
    }
}