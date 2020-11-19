package com.izzist.game.Entity.Tiles;

import com.izzist.game.Entity.Entity;
import com.izzist.game.Game;
import com.izzist.game.sprite.Sprite;

import java.awt.*;

public class TileWall extends Tile {
    public TileWall(int x, int y, int width, int height, Game game) {
        super(x, y, width, height, game);
    }

    @Override
    public void update() {

    }

    @Override
    public boolean isCollide(Entity e) {
        return true;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Sprite.wall, (int) x, (int) y, width, height, null);
    }
}
