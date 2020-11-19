package com.izzist.game.Entity;

import com.izzist.game.Game;
import com.izzist.game.input.KeyHandler;
import com.izzist.game.sprite.Animation;
import com.izzist.game.sprite.Sprite;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Character {
    private int lives = 3;

    private Animation animationUP;
    private Animation animationDown;
    private Animation animationLeft;
    private Animation animationRight;

    private int UP = 0;
    private int DOWN = 1;
    private int LEFT = 0;
    private int RIGHT = 0;


    public Player(float x, float y, int width, int height, Game game) {
        super(x, y, width, height, game);

        speed = 1.2f;
        deAcceleration = 0.3f;
        acceleration = 0.3f;

        bounds = new Rectangle(7, 4, 18, 24);

        animationUP = new Animation(100, Sprite.player_up);
        animationDown = new Animation(100, Sprite.player_down);
        animationRight = new Animation(100, Sprite.player_right);
        animationLeft = new Animation(100, Sprite.player_left);
    }

    @Override
    public void update() {
        input(game.getKeyHandler());
        animationDown.update();
        animationLeft.update();
        animationUP.update();
        animationRight.update();
        move();
        x += dx;
        y += dy;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) x, (int) y, 32, 32, null);
        g.setColor(Color.BLUE);
        g.drawRect((int) x + bounds.x, (int) y + bounds.y, bounds.width, bounds.height);
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


    private BufferedImage getCurrentAnimationFrame() {
        if (up) {
            UP = 1;
            DOWN = 0;
            LEFT = 0;
            RIGHT = 0;
            return animationUP.getCurrentFrame();

        } else if (right) {
            UP = 0;
            DOWN = 0;
            LEFT = 0;
            RIGHT = 1;
            return animationRight.getCurrentFrame();
        } else if (left) {
            UP = 0;
            DOWN = 0;
            LEFT = 1;
            RIGHT = 0;
            return animationLeft.getCurrentFrame();
        } else if (down) {
            UP = 0;
            DOWN = 1;
            LEFT = 0;
            RIGHT = 0;
            return animationDown.getCurrentFrame();
        } else {
            if (UP == 1) {
                return Sprite.player_up[0];
            } else if (RIGHT == 1){
                return Sprite.player_right[0];
            } else if(LEFT==1){
                return Sprite.player_left[0];
            } else return Sprite.player_down[0];
        }
    }

}
