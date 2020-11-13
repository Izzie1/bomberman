package com.izzist.game.map.tiles;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.AABB;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public abstract class Tile {
    public Vector2D position;
    public Sprite sprite;
    public int size;
    private Rectangle bounds;

    public Tile(Vector2D position, int size) {
        this.position = position;
        this.size = size;
        this.sprite = new Sprite("tile/Wall.png", 16, 16);
    }

    public abstract void render(Graphics2D g2D);

    public abstract boolean isSolid();


}
