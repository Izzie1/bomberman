package com.izzist.game.map.tiles;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public abstract class Tile {
    Vector2D position;
    Sprite sprite;
    int size;

    public Tile(Vector2D position,int size){
        this.position = position;
        this.size = size;
        this.sprite = new Sprite("tile/tiles_bomberman.png", 16, 16);
    }

    public abstract void render(Graphics2D g2D);

    public abstract void update();
}
