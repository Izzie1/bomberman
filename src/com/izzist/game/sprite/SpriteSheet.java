package com.izzist.game.sprite;


import java.awt.image.BufferedImage;

public class SpriteSheet {
    private BufferedImage sheet;

    /**
     * Constructor.
     *
     * @param sheet anh.
     */
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /**
     * Dung de chia spritesheet.
     * @param x toa do x
     * @param y toa do y
     * @param width chieu rong
     * @param height chieu dai
     * @return
     */
    public BufferedImage getImage(int x, int y, int width, int height){
        return sheet.getSubimage(x,y,width,height);
    }
}
