package com.izzist.game.map.tiles;

import com.izzist.game.entity.Entity;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.map.MapLoader;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class TileGrass extends Tile{


    public TileGrass(Vector2D position, int size) {
        super(position,size);
        switch (MapLoader.level){
            case 1:
                this.sprite = new Sprite(MapLoader.mapSprite[1], 16, 16);
                break;
            case 2:
                this.sprite = new Sprite(MapLoader.mapSprite[3], 16, 16);
                break;
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(sprite.getSprite(3,0), (int) (position.x), (int) (position.y), size, size, null);
    }

}