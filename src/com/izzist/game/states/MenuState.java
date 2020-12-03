package com.izzist.game.states;

import com.izzist.game.GamePanel;
import com.izzist.game.graphics.Animation;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.ultility.KeyHandler;

import java.awt.*;

public class MenuState extends GameState {
    private Animation animation;

    public MenuState(GameStateManager gameStateManager) {
        super(gameStateManager);
        animation = new Animation();
        animation.setFrames(Sprite.beginning);
        animation.setDelay(10);
    }

    @Override
    public void update() {
        animation.update();
    }

    @Override
    public void input(KeyHandler key) {
        if (key.enter.down) {
            gameStateManager.pop(GameStateManager.MENU);
            gameStateManager.add(GameStateManager.PLAY);
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(Sprite.menu, 0, 0, GamePanel.width, GamePanel.height, null);
        g2D.drawImage(animation.getImage(), GamePanel.width / 2 - 48,
                GamePanel.height / 2 - 48, 97, 97, null);
    }
}
