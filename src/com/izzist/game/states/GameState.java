package com.izzist.game.states;

import com.izzist.game.graphics.Sprite;
import com.izzist.game.managers.AudioPlayer;
import com.izzist.game.ultility.KeyHandler;

import java.awt.Graphics2D;

/**
 * lop truu tuong cho cac state.
 */
public abstract class GameState {
    protected GameStateManager gameStateManager;
    protected Sprite sprite;
    protected AudioPlayer bgMusic;


    public GameState(GameStateManager gameStateManager) {
        this.gameStateManager = gameStateManager;
        sprite = new Sprite();
    }

    public abstract void update();

    public abstract void input(KeyHandler key);

    public abstract void render(Graphics2D g2D);

}
