package com.izzist.game.map.tiles;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

/**
 * class cho Tile trong game.
 */
public abstract class Tile {
    protected Vector2D position;
    protected Sprite sprite;
    protected int size;
    protected Rectangle rectangle;

    public Tile(Vector2D position, int size) {
        this.position = position;
        this.size = size;
        rectangle = new Rectangle((int) position.x, (int) position.y, size, size);
    }

    public abstract void render(Graphics2D g2D);

    public Vector2D getPosition() {
        return position;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }
}
