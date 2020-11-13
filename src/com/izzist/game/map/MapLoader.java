package com.izzist.game.map;

import com.izzist.game.map.managers.TileManager;
import com.izzist.game.map.tiles.Tile;
import com.izzist.game.map.tiles.TileGrass;
import com.izzist.game.map.tiles.TileWall;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MapLoader {
    private int level;
    private int width;
    private int height;
    private String[] lineTiles;
    private final int TILE_SIZE = 32;


    public void readMap() {

        try {
            File path = new File("data/map/Level1/Level1.txt");
            Scanner myReader = new Scanner(path);
            String data = myReader.nextLine();
            StringTokenizer tokens = new StringTokenizer(data);

            level = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());
            lineTiles = new String[height];
            TileManager.tileManager = new Tile[width][height];
            for (int i = 0; i < height; ++i) {
                lineTiles[i] = myReader.nextLine().substring(0, width);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                switch (lineTiles[y].charAt(x)) {
                    case '#': {
                        TileWall tileWall = new TileWall(new Vector2D(x * TILE_SIZE, y * TILE_SIZE), 32);
                        TileManager.tileManager[x][y] = tileWall;

                        break;
                    }
                    default: {
                        TileGrass tileGrass = new TileGrass(new Vector2D(x * TILE_SIZE, y * TILE_SIZE), 32);

                        TileManager.tileManager[x][y] = tileGrass;

                        break;
                    }
                }
            }
        }
    }


    public void render(Graphics2D g2D) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                TileManager.tileManager[x][y].render(g2D);
            }
        }
    }

    public void update(Graphics2D g2D) {

    }


}
