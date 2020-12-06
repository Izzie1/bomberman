package com.izzist.game.states;

import com.izzist.game.GamePanel;
import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.AudioPlayer;
import com.izzist.game.ultility.KeyHandler;

import java.awt.*;

public class GameoverState extends GameState {
    public GameoverState(GameStateManager gameStateManager) {
        super(gameStateManager);
        bgMusic = new AudioPlayer("/sound/lose.mp3");
        bgMusic.play();
    }

    @Override
    public void update() {

    }

    @Override
    public void input(KeyHandler key) {
        key.enter.tick();
        if (key.enter.clicked) {
            bgMusic.stop();
            gameStateManager.pop(GameStateManager.GAMEOVER);
            gameStateManager.add(GameStateManager.MENU);
        }
    }

    @Override
    public void render(Graphics2D g2D) {
        g2D.drawImage(Sprite.gameOver, 0, 0, GamePanel.width, GamePanel.height, null);
    }
}
