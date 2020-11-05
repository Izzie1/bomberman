package com.izzist.game.tiles.blocks;

import com.izzist.game.ultility.AABB;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class NormBlock extends Block{

    public NormBlock(BufferedImage img, Vector2D pos, int w, int h) {
        super(img, pos, w, h);
    }

    @Override
    public boolean update(AABB p) {
        return false;
    }

    public void render (Graphics2D g2D){

        super.render(g2D);
        g2D.setColor(Color.GREEN);
        g2D.drawRect((int) pos.getWorldXY().x,(int) pos.getWorldXY().y,w,h);
    }
}
