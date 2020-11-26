package com.izzist.game.graphics;

import java.awt.image.BufferedImage;

public class Sprite extends SpriteSheet {

    private static BufferedImage player;
    private BufferedImage[][] spriteArray;

    private int spritePerWidth;
    private int spriteHeight;

    public static BufferedImage balloom_dead;
    public static BufferedImage []playerDead;



    public Sprite(String path, int tileSizeWidth, int tileSizeHeight) {

        super(path, tileSizeWidth, tileSizeHeight);
        spriteSheet = loadSprite(path);
        spritePerWidth = spriteSheet.getWidth() / tileSizeWidth;
        spriteHeight = spriteSheet.getHeight() / tileSizeWidth;
        loadSpriteArray();
        init();
    }

    public Sprite() {
        init();
    }

    private void init(){
        playerDead = new BufferedImage[8];
        balloom_dead = loadSprite("font/balloom_dead.png");
        player = loadSprite("font/bomberman 24x24 - Copy.png");
        playerDead[0] = player.getSubimage(0, 12*24, 24, 24);
        playerDead[1] = player.getSubimage(0, 13*24, 24, 24);
        playerDead[2] = player.getSubimage(0, 14*24, 24, 24);
        playerDead[3] = player.getSubimage(0, 15*24, 24, 24);
        playerDead[4] = player.getSubimage(0, 16*24, 24, 24);
        playerDead[5] = player.getSubimage(0, 17*24, 24, 24);
        playerDead[6] = player.getSubimage(0, 18*24, 24, 24);
        playerDead[7] = player.getSubimage(0, 19*24, 24, 24);
    }


    public void loadSpriteArray() {
        spriteArray = new BufferedImage[spriteHeight][spritePerWidth];

        for (int i = 0; i < spriteHeight; i++) {
            for (int j = 0; j < spritePerWidth; j++) {
                spriteArray[i][j] = getSprite(j, i);
            }
        }
    }

    public BufferedImage getSprite(int x, int y) {
        return spriteSheet.getSubimage(x * tileSizeWidth, y * tileSizeHeight, tileSizeWidth, tileSizeHeight);
    }

    public BufferedImage getSprite2(int x, int y, int tileSizeWidth, int tileSizeHeight) {
        return spriteSheet.getSubimage(x * tileSizeWidth, y * tileSizeHeight, tileSizeWidth, tileSizeHeight);
    }

    public BufferedImage[] getSpriteArray(int position, int characterNumber) {
        BufferedImage[] spriteArray2 = new BufferedImage[3];
        for (int i = 0; i < 3; i++) {
            spriteArray2[i] = spriteArray[position * 3 + i][characterNumber];
        }
        return spriteArray2;
    }

    public BufferedImage[] getSpriteArray2(int position) {
        return spriteArray[position];
    }

}
