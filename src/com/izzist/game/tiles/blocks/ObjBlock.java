package com.izzist.game.tiles.blocks;

import com.izzist.game.ultility.AABB;
import com.izzist.game.ultility.Vector2D;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjBlock extends Block {

    public ObjBlock(BufferedImage img, Vector2D pos, int w, int h) {
        super(img, pos, w, h);
    }

    @Override
    public boolean update(AABB p) {
        return true;
    }

    public void render (Graphics2D g2D){
        super.render(g2D);


    }
}
