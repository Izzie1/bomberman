package com.izzist.game.entity;

import com.izzist.game.managers.BombManager;
import com.izzist.game.managers.TileManager;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

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

    public boolean collision(float ax, float ay) {
        for (int c = 0; c < 4; c++) {
            int xt = ((int) (bounds.position.x + ax + bounds.getxOffset()) + (c % 2) * bounds.getWidth()) / 32;
            int yt = (int) ((bounds.position.y + ay + bounds.getyOffset()) + (c / 2) * bounds.getHeight() + bounds.getyOffset()) / 32;
            if ((TileManager.tileManager[xt][yt] != null && TileManager.tileManager[xt][yt].isCollide(this)) ||
                    (TileManager.getBrick(xt,yt) != null && TileManager.getBrick(xt,yt).isCollide(this))) {
                return true;
            }
        }
        return false;
    }


    private boolean isAlive;

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
