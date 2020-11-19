package com.izzist.game.sprite;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Class dung de load anh.
 */
public class ImageLoader {
    /**
     * Constructor.
     * @param path duong dan toi anh
     * @return tra ve anh load dc
     */
    public static BufferedImage loadImage(String path) {
        try{
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
