package com.izzist.game.graphics;

import java.awt.image.BufferedImage;

/**
 * Class dung de cat Sprite va phan chia cac Sprite trong Spritesheet.
 */
public class Sprite extends SpriteSheet {


    private BufferedImage[][] spriteArray;

    private int spritePerWidth;
    private int spriteHeight;

    public static BufferedImage menu;
    public static BufferedImage gameOver;
    public static BufferedImage victory;
    public static BufferedImage title;
    public static BufferedImage balloom;
    public static BufferedImage beginningImg;
    public static BufferedImage oneal;
    public static BufferedImage live;
    public static BufferedImage select;
    public static BufferedImage deSelect;
    public static BufferedImage selectImg;
    public static BufferedImage deSelectImg;
    public static BufferedImage Icon;
    public static BufferedImage player;

    public static BufferedImage[] hud;
    public static BufferedImage[] bomImg;
    public static BufferedImage[] level;
    public static BufferedImage[] beginning;
    public static BufferedImage[] playerDead;
    public static BufferedImage[] balloom_right;
    public static BufferedImage[] balloom_left;
    public static BufferedImage[] balloom_dead;
    public static BufferedImage[] oneal_right;
    public static BufferedImage[] oneal_left;
    public static BufferedImage[] oneal_dead;
    public static BufferedImage[] kondoria_dead;
    public static BufferedImage[] kondoria_left;
    public static BufferedImage[] kondoria_right;
    public static BufferedImage[] doll_left;
    public static BufferedImage[] doll_right;
    public static BufferedImage[] doll_dead;
    public static BufferedImage[] minvo_left;
    public static BufferedImage[] minvo_right;
    public static BufferedImage[] minvo_dead;


    public Sprite(String path, int tileSizeWidth, int tileSizeHeight) {

        super(path, tileSizeWidth, tileSizeHeight);
        spriteSheet = loadSprite(path);
        spritePerWidth = spriteSheet.getWidth() / tileSizeWidth;
        spriteHeight = spriteSheet.getHeight() / tileSizeWidth;
        loadSpriteArray();

    }

    public Sprite() {

    }

    public static void init() {
        balloom = loadSprite("assets/Balloom.png");
        player = loadSprite("assets/bomberman 24x24.png");
        oneal = loadSprite("assets/Oneal.png");
        gameOver = loadSprite("states/gameover.png");
        menu = loadSprite("states/Background.png");
        beginningImg = loadSprite("states/beginning.png");
        victory = loadSprite("states/end.png");
        live = loadSprite("hudsprite/live.png");
        title = loadSprite("hudsprite/Title_Sprite.png");
        select = loadSprite("hudsprite/Select.png");
        deSelect = loadSprite("hudsprite/Deselect.png");
        selectImg = loadSprite("hudsprite/SelectButton.png");
        deSelectImg = loadSprite("hudsprite/Deselectbutton.png");
        Icon = loadSprite("hudsprite/bomb.png");

        hud = new BufferedImage[26];
        level = new BufferedImage[4];
        playerDead = new BufferedImage[8];
        balloom_right = new BufferedImage[3];
        balloom_left = new BufferedImage[3];
        balloom_dead = new BufferedImage[5];
        oneal_right = new BufferedImage[4];
        oneal_left = new BufferedImage[4];
        oneal_dead = new BufferedImage[5];
        kondoria_left = new BufferedImage[3];
        kondoria_right = new BufferedImage[3];
        kondoria_dead = new BufferedImage[4];
        doll_left = new BufferedImage[3];
        doll_right = new BufferedImage[3];
        doll_dead = new BufferedImage[4];
        minvo_left = new BufferedImage[3];
        minvo_right = new BufferedImage[3];
        minvo_dead = new BufferedImage[4];
        beginning = new BufferedImage[5];
        bomImg = new BufferedImage[10];

        level[0] = loadSprite("hudsprite/level1.png");
        level[1] = loadSprite("hudsprite/level2.png");
        level[2] = loadSprite("hudsprite/level3.png");
        level[3] = loadSprite("hudsprite/level4.png");


        beginning[0] = beginningImg.getSubimage(0, 0, 97, 97);
        beginning[1] = beginningImg.getSubimage(97, 0, 97, 97);
        beginning[2] = beginningImg.getSubimage(97 * 2, 0, 97, 97);
        beginning[3] = beginningImg.getSubimage(97 * 3, 0, 97, 97);
        beginning[4] = beginningImg.getSubimage(97 * 4, 0, 97, 97);


        playerDead[0] = player.getSubimage(0, 12 * 24, 24, 24);
        playerDead[1] = player.getSubimage(0, 13 * 24, 24, 24);
        playerDead[2] = player.getSubimage(0, 14 * 24, 24, 24);
        playerDead[3] = player.getSubimage(0, 15 * 24, 24, 24);
        playerDead[4] = player.getSubimage(0, 16 * 24, 24, 24);
        playerDead[5] = player.getSubimage(0, 17 * 24, 24, 24);
        playerDead[6] = player.getSubimage(0, 18 * 24, 24, 24);
        playerDead[7] = player.getSubimage(0, 19 * 24, 24, 24);

        balloom_left[0] = balloom.getSubimage(0, 0, 16, 16);
        balloom_left[1] = balloom.getSubimage(16, 0, 16, 16);
        balloom_left[2] = balloom.getSubimage(2 * 16, 0, 16, 16);
        balloom_right[0] = balloom.getSubimage(3 * 16, 0, 16, 16);
        balloom_right[1] = balloom.getSubimage(4 * 16, 0, 16, 16);
        balloom_right[2] = balloom.getSubimage(5 * 16, 0, 16, 16);
        balloom_dead[0] = balloom.getSubimage(6 * 16, 0, 16, 16);
        balloom_dead[1] = balloom.getSubimage(7 * 16, 0, 16, 16);
        balloom_dead[2] = balloom.getSubimage(8 * 16, 0, 16, 16);
        balloom_dead[3] = balloom.getSubimage(9 * 16, 0, 16, 16);
        balloom_dead[4] = balloom.getSubimage(10 * 16, 0, 16, 16);

        oneal_left[0] = oneal.getSubimage(0, 0, 16, 16);
        oneal_left[1] = oneal.getSubimage(16, 0, 16, 16);
        oneal_left[2] = oneal.getSubimage(2 * 16, 0, 16, 16);
        oneal_left[3] = oneal.getSubimage(3 * 16, 0, 16, 16);
        oneal_right[0] = oneal.getSubimage(4 * 16, 0, 16, 16);
        oneal_right[1] = oneal.getSubimage(5 * 16, 0, 16, 16);
        oneal_right[2] = oneal.getSubimage(6 * 16, 0, 16, 16);
        oneal_right[3] = oneal.getSubimage(7 * 16, 0, 16, 16);
        oneal_dead[0] = oneal.getSubimage(8 * 16, 0, 16, 16);
        oneal_dead[1] = oneal.getSubimage(9 * 16, 0, 16, 16);
        oneal_dead[2] = oneal.getSubimage(10 * 16, 0, 16, 16);
        oneal_dead[3] = oneal.getSubimage(11 * 16, 0, 16, 16);
        oneal_dead[4] = oneal.getSubimage(12 * 16, 0, 16, 16);

        kondoria_dead[0] = loadSprite("assets/kondoria_dead.png");
        kondoria_dead[1] = loadSprite("assets/mob_dead1.png");
        kondoria_dead[2] = loadSprite("assets/mob_dead2.png");
        kondoria_dead[3] = loadSprite("assets/mob_dead3.png");
        kondoria_left[0] = loadSprite("assets/kondoria_left1.png");
        kondoria_left[1] = loadSprite("assets/kondoria_left2.png");
        kondoria_left[2] = loadSprite("assets/kondoria_left3.png");
        kondoria_right[0] = loadSprite("assets/kondoria_right1.png");
        kondoria_right[1] = loadSprite("assets/kondoria_right2.png");
        kondoria_right[2] = loadSprite("assets/kondoria_right3.png");

        doll_dead[0] = loadSprite("assets/doll_dead.png");
        doll_dead[1] = loadSprite("assets/mob_dead1.png");
        doll_dead[2] = loadSprite("assets/mob_dead2.png");
        doll_dead[3] = loadSprite("assets/mob_dead3.png");
        doll_left[0] = loadSprite("assets/doll_left1.png");
        doll_left[1] = loadSprite("assets/doll_left2.png");
        doll_left[2] = loadSprite("assets/doll_left3.png");
        doll_right[0] = loadSprite("assets/doll_right1.png");
        doll_right[1] = loadSprite("assets/doll_right2.png");
        doll_right[2] = loadSprite("assets/doll_right3.png");

        minvo_dead[0] = loadSprite("assets/minvo_dead.png");
        minvo_dead[1] = loadSprite("assets/mob_dead1.png");
        minvo_dead[2] = loadSprite("assets/mob_dead2.png");
        minvo_dead[3] = loadSprite("assets/mob_dead3.png");
        minvo_left[0] = loadSprite("assets/minvo_left1.png");
        minvo_left[1] = loadSprite("assets/minvo_left2.png");
        minvo_left[2] = loadSprite("assets/minvo_left3.png");
        minvo_right[0] = loadSprite("assets/minvo_right1.png");
        minvo_right[1] = loadSprite("assets/minvo_right2.png");
        minvo_right[2] = loadSprite("assets/minvo_right3.png");
        for (int i = 0; i < 10; i++) {
            bomImg[i] = title.getSubimage(0, 172 * i, 597, 172);
        }

        for (int i = 0; i < 26; i++) {
            int png = i + 1;
            hud[i] = loadSprite("hudsprite/" + png + ".png");
        }
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
