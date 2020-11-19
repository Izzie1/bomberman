package com.izzist.game.Entity;

import com.izzist.game.Game;
import com.izzist.game.input.KeyHandler;
import com.izzist.game.sprite.Sprite;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Player extends Character {
    private int lives = 3;
    private Game game;

    public Player(float x, float y, int width, int height, Game game) {
        super(x, y, width, height);
        this.game = game;

        speed = 1.5f;
        deAcceleration = 0.1f;
        acceleration = 0.2f;

        bounds = new Rectangle();
        bounds.x = 6;
        bounds.y = 4;
        bounds.width = 20;
        bounds.height = 24;


    }

    @Override
    public void update() {
        input(game.getKeyHandler());
        move();
        x += dx;
        y += dy;

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Sprite.player, (int) x, (int) y, width, height, null);
        g.setColor(Color.BLUE);
        g.drawRect((int)x+bounds.x, (int)y+bounds.y, bounds.width, bounds.height);
    }

    private void input(KeyHandler key) {
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
    }

    private void move() {
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

}
