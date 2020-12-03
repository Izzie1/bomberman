package com.izzist.game.states;

import com.izzist.game.GamePanel;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.KeyHandler;

import java.awt.*;

public class GameoverState extends GameState {
    public GameoverState(GameStateManager gameStateManager) {
        super(gameStateManager);
    }

    @Override
    public void update() {

    }

    @Override
    public void input(KeyHandler key) {
        if(key.enter.down){
            gameStateManager.pop(GameStateManager.GAMEOVER);
            gameStateManager.add(GameStateManager.MENU);
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(Sprite.gameOver,0,0, GamePanel.width,GamePanel.height,null);
    }
}
