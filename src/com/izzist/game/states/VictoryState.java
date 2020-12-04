package com.izzist.game.states;

import com.izzist.game.GamePanel;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.KeyHandler;

import java.awt.*;

public class VictoryState extends GameState {
    public VictoryState(GameStateManager gameStateManager) {
        super(gameStateManager);
    }

    @Override
    public void update() {

    }

    @Override
    public void input(KeyHandler key) {
        key.enter.tick();
        if(key.enter.clicked){
            gameStateManager.pop(GameStateManager.VICTORY);
            gameStateManager.add(GameStateManager.MENU);
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(Sprite.victory,0,0, GamePanel.width,GamePanel.height,null);
    }
}
