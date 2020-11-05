package com.izzist.game.tiles;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.tiles.blocks.Block;
import com.izzist.game.tiles.blocks.NormBlock;
import com.izzist.game.tiles.blocks.ObjBlock;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class TilemapObj extends TileMap {

    public static HashMap<String, Block> tmo_blocks;

    public TilemapObj(String data, Sprite sprite, int width,
                      int height, int tileWidth, int tileHeight, int tileColumns) {
        Block tempBlock;
        tmo_blocks = new HashMap<String, Block>();
        String[] block = data.split(",");
        for (int i = 0; i < width * height; i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0) {
                tempBlock = new ObjBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns)),
                        new Vector2D((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight);
                tmo_blocks.put(String.valueOf((int) (i % width)) + "," + String.valueOf((int) (i / height)), tempBlock);
            }
        }
    }

    public void render(Graphics2D g2D) {
        for (Block block : tmo_blocks.values()) {
            block.render(g2D);
        }
    }
}
