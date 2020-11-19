package com.izzist.game.sprite;


import java.awt.image.BufferedImage;

/**
 * Class de lay cac sprite trong spritesheet.
 */
public class Sprite {
    public static BufferedImage player;
    public static BufferedImage bomb;
    public static BufferedImage wall;
    public static BufferedImage grass;
    public static BufferedImage brick;

    /**
     * Lay cac sheet trong Spritesheet.
     */
    public static void init() {
        SpriteSheet playerSheet = new SpriteSheet(ImageLoader.loadImage("/font/bomberman 24x24.png"));
        SpriteSheet bombSheet = new SpriteSheet(ImageLoader.loadImage("/font/BombGreen_16_16.png"));
        SpriteSheet wallAndGrass = new SpriteSheet(ImageLoader.loadImage("/tile/Wall.png"));

        player = playerSheet.getImage(0,0,24,24);
        grass = wallAndGrass.getImage(48,0,16,16);
        wall = wallAndGrass.getImage(16,16,16,16);
    }

}
