package com.izzist.game.ultility;

import com.izzist.game.managers.TileManager;

public class AABB {
    private int width;
    private int height;
    public Vector2D position;
    private int xOffset;
    private int yOffset;

    public AABB(int width, int height, Vector2D position, int xOffset, int yOffset) {
        this.width = width;
        this.height = height;
        this.position = position;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public boolean collision(float ax, float ay) {
        for (int c = 0; c < 4; c++) {
            System.out.println(c);
            int xt = ((int) (position.x + ax + xOffset) + (c % 2) * width) / 32;
            int yt = (int) ((position.y + ay + yOffset) + (c / 2) * height + yOffset) / 32;
            if (TileManager.tileManager[xt][yt] != null && TileManager.tileManager[xt][yt].isCollide(this)) {
                return true;
            }
        }
        return false;
    }

    public boolean collisionWitBrick(float ax, float ay) {
        for (int c = 0; c < 4; c++) {
            System.out.println(c);
            int xt = ((int) (position.x + ax + xOffset) + (c % 2) * width) / 32;
            int yt = (int) ((position.y + ay + yOffset) + (c / 2) * height + yOffset) / 32;
            if (TileManager.tileBrickManager[xt][yt] != null && TileManager.tileBrickManager[xt][yt].isCollide(this)) {
                return true;
            }
        }
        return false;
    }


    public int getxOffset() {
        return xOffset;
    }

    public void setxOffset(int xOffset) {
        this.xOffset = xOffset;
    }

    public int getyOffset() {
        return yOffset;
    }

    public void setyOffset(int yOffset) {
        this.yOffset = yOffset;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
