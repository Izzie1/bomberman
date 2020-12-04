package com.izzist.game.map.tiles;

import com.izzist.game.entity.Entity;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.map.MapLoader;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;

public class TileWall extends Tile{


    public TileWall(Vector2D position,int size) {
        super(position,size);
        switch (MapLoader.level){
            case 1:
                this.sprite = new Sprite(MapLoader.mapSprite[1], 16, 16);
                break;
            case 2:
                this.sprite = new Sprite(MapLoader.mapSprite[3], 16, 16);
                break;
            case 3:
                this.sprite = new Sprite(MapLoader.mapSprite[5], 16, 16);
                break;
            case 4:
                this.sprite = new Sprite(MapLoader.mapSprite[7], 16, 16);
                break;
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.setColor(Color.RED);
        g2D.drawRect((int) (position.x), (int) (position.y ), 32, 32);
        g2D.drawImage(sprite.getSprite(1,1), (int) (position.x), (int) (position.y), size, size, null);
    }

}
