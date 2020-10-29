package com.izzist.game.states;

import com.izzist.game.graphics.Font;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.KeyHandler;
import com.izzist.game.ultility.Vector2D;


import java.awt.Graphics2D;

public class PlayState extends GameState {
    private Font font;
    public PlayState(GameStateManager gameStateManager) {
        super((gameStateManager));
        font = new Font("font/bombermanfont.png",32,32);
    }

    @Override
    public void update() {

    }

    @Override
    public void input(KeyHandler key) {

    }

    @Override
    public void render(Graphics2D g2D) {
        Sprite.drawArray(g2D,font,"A B",new Vector2D(100,100)
                ,32,32,0,0);
    }
}
