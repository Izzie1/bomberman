package com.izzist.game.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Class dung de lay Spritesheet.
 */
public class SpriteSheet {

    protected String path;
    protected int tileSizeWidth;
    protected int tileSizeHeight;
    protected BufferedImage spriteSheet;


    public SpriteSheet(String path, int tileSizeWidth, int tileSizeHeight) {
        this.path = path;
        this.tileSizeWidth = tileSizeWidth;
        this.tileSizeHeight = tileSizeHeight;
        loadSprite(path);
    }

    public SpriteSheet() {

    }

    public static BufferedImage loadSprite(String path) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(SpriteSheet.class.getClassLoader().getResourceAsStream(path));
        } catch (Exception e) {
            System.out.println("could not load file" + path);
        }
        return sprite;
    }
}
