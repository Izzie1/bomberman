package com.izzist.game.map;

import com.izzist.game.Entity.Tiles.Tile;
import com.izzist.game.Entity.Tiles.TileGrass;
import com.izzist.game.Entity.Tiles.TileWall;
import com.izzist.game.Game;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class World {
    private int level;
    private int width;
    private int height;
    private String[] lineTiles;
    private final int TILE_SIZE = 32;
    public static Tile[][] tiles;
    private Game game;

    public World(String resource, Game game) {
        loadMap(resource);
        this.game = game;
    }


    public void loadMap(String resource) {

        try {
            File path = new File(resource);
            Scanner myReader = new Scanner(path);
            String data = myReader.nextLine();
            StringTokenizer tokens = new StringTokenizer(data);

            level = Integer.parseInt(tokens.nextToken());
            height = Integer.parseInt(tokens.nextToken());
            width = Integer.parseInt(tokens.nextToken());
            lineTiles = new String[height];
            tiles = new Tile[width][height];
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
                        TileWall tileWall = new TileWall(x * TILE_SIZE, y * TILE_SIZE,
                                TILE_SIZE, TILE_SIZE, this.game);
                        tiles[x][y] = tileWall;
                        break;
                    }
                    default: {
                        TileGrass tileGrass = new TileGrass(x * TILE_SIZE, y * TILE_SIZE,
                                TILE_SIZE, TILE_SIZE, this.game);
                        tiles[x][y] = tileGrass;
                        break;
                    }
                }
            }
        }
    }

    public static Tile getTile(int x,int y){
        return tiles[x][y];
    }

    public void render(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y].render(g);
            }
        }
    }

    public void update(Graphics g) {

    }

}

