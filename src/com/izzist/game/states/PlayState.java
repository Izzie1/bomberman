package com.izzist.game.states;

import com.izzist.game.entity.Player;
import com.izzist.game.graphics.Font;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.tiles.TileManager;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;


import java.awt.Graphics2D;

public class PlayState extends GameState {
    private Player player;
    private TileManager tm;
    public PlayState(GameStateManager gameStateManager) {
        super((gameStateManager));
        tm=new TileManager("tile/map1.xml");
        player = new Player(new Sprite("font/bomberman 24x24 - Copy.png"),new Vector2D(32,32),32);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void input(KeyHandler key) {
        player.input(key);
    }

    @Override
    public void render(Graphics2D g2D) {
        tm.render(g2D);
        player.render(g2D);
    }
}
