package com.izzist.game.ultility;

import com.izzist.game.entity.Entity;

public class AABB {
    private Vector2D pos;
    private float w;
    private float h;
    private float radius;
    private int size;
    private float xOffset = 0;
    private float yOffset = 0;
    private Entity entity;

    public AABB(Vector2D pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;


        size = Math.max(w, h);

    }

    public AABB(Vector2D pos, int r, Entity entity) {
        this.pos = pos;
        this.radius = r;
        this.entity = entity;
        size = r;
    }


    public Vector2D getPos() {
        return pos;
    }

    public float getWidth() {
        return w;
    }

    public void setWidth(float w) {
        this.w = w;
    }

    public float getHeight() {
        return h;
    }

    public void setHeight(float h) {
        this.h = h;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setBox(Vector2D pos, int w, int h) {
        this.pos = pos;
        this.w = w;
        this.h = h;
        size = Math.max(w, h);
    }

    public void setCircle(Vector2D pos, int r) {
        this.pos = pos;
        this.radius = r;
        size = r;
    }

    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

    public boolean collided(AABB bBox) {
        float ax = ((pos.getWorldXY().x + xOffset + w / 2));
        float ay = ((pos.getWorldXY().y + yOffset + h / 2));
        float bx = (bBox.pos.getWorldXY().x + xOffset / 2 + w / 2);
        float by = (bBox.pos.getWorldXY().y + bBox.yOffset / 2 + h / 2);
        if (Math.abs(ax - bx) < this.w / 2 + bBox.h / 2) {
            if (Math.abs(ay - by) < this.h / 2 + bBox.h / 2) {
                return true;
            }
        }
        return false;
    }

    public boolean colCircleBox(AABB aBox) {
        float cx = (float) (pos.getWorldXY().x + radius / Math.sqrt(2) - entity.getSize() / Math.sqrt(2));
        float cy = (float) (pos.getWorldXY().y + radius / Math.sqrt(2) - entity.getSize() / Math.sqrt(2));

        float xDelta = cx - Math.max(aBox.pos.getWorldXY().x + (aBox.getWidth() / 2), Math.min(cx, aBox.pos.getWorldXY().x));
        float yDelta = cy - Math.max(aBox.pos.getWorldXY().y + (aBox.getWidth() / 2), Math.min(cy, aBox.pos.getWorldXY().y));
        if ((xDelta * xDelta + yDelta * yDelta) < ((this.radius / Math.sqrt(2)) * (this.radius / Math.sqrt(2)))) {
            return true;
        }
        return false;
    }
}
