package com.izzist.game.entity;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.entity.Bomb.Flame;
import com.izzist.game.graphics.Animation;
import com.izzist.game.managers.BombManager;
import com.izzist.game.managers.TileManager;
import com.izzist.game.map.tiles.Tile;
import com.izzist.game.map.tiles.TileBrick;
import com.izzist.game.map.tiles.TileWall;
import com.izzist.game.states.PlayState;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Character extends Entity {
    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;

    protected final int UP = 3;
    protected final int DOWN = 0;
    protected final int RIGHT = 1;
    protected final int LEFT = 2;

    protected float dx;
    protected float dy;
    protected float speed;
    protected float acceleration;
    protected float deAcceleration;

    protected boolean isAlive = true;
    protected Animation dead_animation;

    /**
     * animation.
     */
    public abstract void animate();

    /**
     * check va cham tuong.
     */
    public boolean collisionWall(float ax, float ay) {
        if (TileManager.tileManager != null) {
            for (Tile t : TileManager.tileManager) {
                if (t instanceof TileWall && collisionRect(ax, ay).intersects(t.getRectangle())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check va cham gach.
     */
    public boolean collisionBrick(float ax, float ay) {
        if (TileManager.tileBrickManager != null) {
            for (Tile t : TileManager.tileBrickManager) {
                if (t instanceof TileBrick && collisionRect(ax, ay).intersects(t.getRectangle())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check va cham bomb.
     */
    public boolean collisionBomb(float ax, float ay) {
        if (BombManager.bombs != null) {
            for (Bomb b : BombManager.bombs) {
                if (collisionRect(ax, ay).intersects(b.getRectangle())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * check va cham flame.
     */
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

    /**
     * update hitbox.
     */
    public void updateRect() {
        rectangle.setRect(position.x + xOffSet, position.y + yOffSet,
                rectangle.getWidth(), rectangle.getHeight());
    }

    public float getDx() {
        return dx;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Animation getDead_animation() {
        return dead_animation;
    }

    public void setDead_animation(Animation dead_animation) {
        this.dead_animation = dead_animation;
    }

    /**
     * check hitbox di chuyen.
     */
    public Rectangle2D collisionRect(float ax, float ay) {
        return new Rectangle2D.Float((float) (rectangle.getX() + ax), (float) (rectangle.getY() + ay),
                (float) rectangle.getWidth(), (float) rectangle.getHeight());
    }
}
