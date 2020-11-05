package com.izzist.game.tiles.blocks;

import com.izzist.game.ultility.AABB;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Block {
    protected int w;
    protected int h;
    protected BufferedImage img;
    protected Vector2D pos;

    public Block(BufferedImage img, Vector2D pos,int w, int h){
        this.img = img;
        this.pos = pos;
        this.w = w;
        this.h = h;
    }

    public abstract  boolean update(AABB p);

    public void render(Graphics2D g2D){
        g2D.drawImage(img,(int) pos.getWorldXY().x,(int) pos.getWorldXY().y,w,h,null);
    }
}
