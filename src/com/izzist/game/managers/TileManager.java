package com.izzist.game.managers;

import com.izzist.game.map.tiles.Tile;
import com.izzist.game.map.tiles.TileBrick;

public class TileManager {
    public static Tile[][] tileManager;
    public static TileBrick[][] tileBrickManager;

    public static Tile getTile(int x, int y) {
        return tileManager[x][y];
    }

    public static TileBrick getBrick(int x, int y) {
        return tileBrickManager[x][y];
    }
}
