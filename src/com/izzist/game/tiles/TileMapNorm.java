package com.izzist.game.tiles;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.tiles.blocks.Block;
import com.izzist.game.tiles.blocks.NormBlock;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class TileMapNorm extends TileMap {
    private ArrayList<Block> blocks;


    public TileMapNorm(String data, Sprite sprite, int width,
                       int height, int tileWidth, int tileHeight, int tileColumns) {
        blocks = new ArrayList<Block>();
        String[] block = data.split(",");

        for (int i = 0; i < width * height; i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if (temp != 0) {
                blocks.add(new NormBlock(sprite.getSprite((int) ((temp - 1) % tileColumns), (int) ((temp - 1) / tileColumns)),
                new Vector2D((int) (i % width) * tileWidth, (int) (i / height) * tileHeight), tileWidth, tileHeight));
            }
        }
    }

    public void render(Graphics2D g2D) {
        for (int i = 0; i < blocks.size(); i++) {
            blocks.get(i).render(g2D);
        }
    }
}
