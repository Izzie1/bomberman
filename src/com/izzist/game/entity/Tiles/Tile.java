package com.izzist.game.Entity.Tiles;

import com.izzist.game.Entity.Entity;
import com.izzist.game.Game;

import java.awt.*;

public abstract class Tile extends Entity {

    public Tile(int x, int y, int width, int height,Game game) {
        super(x, y, width, height,game);
        bounds = new Rectangle(x,y,width,height);
    }

    public abstract boolean isCollide(Entity e);

    @Override
    public abstract void render(Graphics g);


}
