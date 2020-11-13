package com.izzist.game.map.managers;

import com.izzist.game.map.tiles.Tile;

public class TileManager {
    public static Tile[][] tileManager;

    public static Tile getTile(int x, int y) {
        return tileManager[x][y];
    }
}
