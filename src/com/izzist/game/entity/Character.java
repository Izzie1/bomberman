package com.izzist.game.entity;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.map.managers.TileManager;
import com.izzist.game.states.PlayState;
import com.izzist.game.ultility.Vector2D;

public abstract class Character extends Entity {
    protected boolean up;
    protected boolean down;
    protected boolean right;
    protected boolean left;

    protected float dx;
    protected float dy;
    protected float maxSpeed;
    protected float acceleration;
    protected float deAcceleration;

    private boolean isAlive;

    public Character(Vector2D position, int size) {
        super(position,size);
    }

    public Character(Sprite sprite, Vector2D position, int size) {
        super(sprite, position, size);
    }

    public void movingWithCollision() {
        if (dx > 0) {
            int tx = (int) (bounds.position.x + bounds.getxOffset() + dx + bounds.getWidth()) / 32;

            if (!TileManager.getTile(tx, (int) (position.y + bounds.getyOffset()) / 32).isSolid()
                    && !TileManager.getTile(tx, (int) (position.y + bounds.getyOffset() + 24) / 32).isSolid()) {
                position.x += dx;
            }
        } else if (dx < 0) {
            int tx = (int) (bounds.position.x + bounds.getxOffset() + dx) / 32;
            if (!TileManager.getTile(tx, (int) (position.y + bounds.getyOffset()) / 32).isSolid()
                    && !TileManager.getTile(tx, (int) (position.y + bounds.getyOffset() + bounds.getHeight()) / 32).isSolid()) {
                position.x += dx;
            }
        }

        if (dy < 0) {
            int ty = (int) (bounds.position.y + bounds.getyOffset() + dy) / 32;

            if (!TileManager.getTile((int) (position.x + bounds.getxOffset()) / 32, ty).isSolid()
                    && !TileManager.getTile((int) (position.x + bounds.getxOffset() + bounds.getWidth()) / 32, ty).isSolid()) {
                position.y += dy;
            }
        } else if (dy > 0) {
            int ty = (int) (bounds.position.y + bounds.getyOffset() + dy + bounds.getHeight()) / 32;
            if (!TileManager.getTile((int) (position.x + bounds.getxOffset()) / 32, ty).isSolid()
                    && !TileManager.getTile((int) (position.x + bounds.getxOffset() + bounds.getWidth()) / 32, ty).isSolid()) {
                position.y += dy;
            }
        }
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
}
