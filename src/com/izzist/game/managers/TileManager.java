package com.izzist.game.managers;

import com.izzist.game.entity.Bomb.Bomb;
import com.izzist.game.entity.Item.Item;
import com.izzist.game.map.tiles.Tile;
import com.izzist.game.map.tiles.TileBrick;

import java.awt.*;
import java.util.ArrayList;

public class TileManager {
    public static ArrayList<Tile> tileManager = new ArrayList<>();
    public static ArrayList<TileBrick> tileBrickManager = new ArrayList<>();

    public static Tile getTile(int x, int y) {
        Tile temp = null;
        for (Tile t : tileManager) {
            if ((int)t.getPosition().x/32 == x && (int)t.getPosition().y/32 == y) {
                temp = t;
            }
        }
        return temp;
    }

    public static TileBrick getBrick(int x, int y) {
        TileBrick temp = null;
        for (TileBrick b : tileBrickManager) {
            if ((int)b.getPosition().x/32 == x && (int)b.getPosition().y/32 == y) {
                temp = b;
            }
        }
        return temp;
    }


}
