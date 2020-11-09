package com.izzist.game.map.tiles;

import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class TileGrass extends Tile{


    public TileGrass(Vector2D position, int size) {
        super(position,size);
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(sprite.getSprite(3,0), (int) (position.x), (int) (position.y), size, size, null);
    }

    @Override
    public void update() {

    }
}