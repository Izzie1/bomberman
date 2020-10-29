package com.izzist.game.graphics;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class Font {
    private BufferedImage fontSheet = null;
    private BufferedImage[][] spriteArray;
    private final int TILE_SIZE = 32;
    private int width;
    private int height;

    private int letterWidth;
    private int letterHeight;

    public Font(String path) {
        width = TILE_SIZE;
        height = TILE_SIZE;

        fontSheet = loadFont(path);

        letterWidth = fontSheet.getWidth() / width;
        letterHeight = fontSheet.getHeight() / height;
        loadFontArray();
    }

    public Font (String path, int w, int h) {
        this.width = w;
        this.height = h;
        fontSheet = loadFont(path);
        letterWidth = fontSheet.getWidth() / width;
        letterHeight = fontSheet.getHeight() / height;
        loadFontArray();
    }

    public void setSize(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        letterWidth = fontSheet.getWidth() / width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        letterHeight = fontSheet.getHeight() / height;
    }

    private BufferedImage loadFont(String path) {
        BufferedImage font = null;
        try {
            font = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
        } catch (Exception e) {
            System.out.println("could not load file" + path);

        }
        return font;
    }

    public void loadFontArray() {
        spriteArray = new BufferedImage[letterWidth][letterHeight];

        for (int i = 0; i < letterWidth; i++) {
            for (int j = 0; j < letterHeight; j++) {
                spriteArray[i][j] = getLetter(i, j);
            }
        }
    }

    public BufferedImage getFontSheet() {
        return fontSheet;
    }

    public BufferedImage getLetter(int x, int y) {
        return fontSheet.getSubimage(x * width, y * height, width, height);
    }

    public BufferedImage getFont(char letter) {
        int value = letter - 65;
        int x = value % letterWidth;
        int y = value / letterHeight;
        return fontSheet.getSubimage(x, y, width, height);
    }
}
