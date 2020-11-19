package com.izzist.game.sprite;


import java.awt.image.BufferedImage;

/**
 * Class de lay cac sprite trong spritesheet.
 */
public class Sprite {
    public static BufferedImage bomb;
    public static BufferedImage wall;
    public static BufferedImage grass;
    public static BufferedImage brick;
    public static BufferedImage[] player_up;
    public static BufferedImage[] player_down;
    public static BufferedImage[] player_left;
    public static BufferedImage[] player_right;
    /**
     * Lay cac sheet trong Spritesheet.
     */
    public static void init() {
        player_up = new BufferedImage[3];
        player_down = new BufferedImage[3];
        player_left = new BufferedImage[3];
        player_right = new BufferedImage[3];
        SpriteSheet bombSheet = new SpriteSheet(ImageLoader.loadImage("/font/BombGreen_16_16.png"));
        SpriteSheet wallAndGrass = new SpriteSheet(ImageLoader.loadImage("/tile/Wall.png"));
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/font/bomberman 24x24.png"));

        grass = wallAndGrass.getImage(48,0,16,16);
        wall = wallAndGrass.getImage(16,16,16,16);

        player_down[0] = playerSheet.getImage(0,0,24,24);
        player_down[1] = playerSheet.getImage(0,24,24,24);
        player_down[2] = playerSheet.getImage(0,24*2,24,24);

        player_up[0] = playerSheet.getImage(0,24*9,24,24);
        player_up[1] = playerSheet.getImage(0,24*10,24,24);
        player_up[2] = playerSheet.getImage(0,24*11,24,24);

        player_right[0] = playerSheet.getImage(0,24*3,24,24);
        player_right[1] = playerSheet.getImage(0,24*4,24,24);
        player_right[2] = playerSheet.getImage(0,24*5,24,24);

        player_left[0] = playerSheet.getImage(0,24*6,24,24);
        player_left[1] = playerSheet.getImage(0,24*7,24,24);
        player_left[2] = playerSheet.getImage(0,24*8,24,24);

    }

}
