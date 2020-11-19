package com.izzist.game.states;


import com.izzist.game.Game;

import java.awt.*;

/**
 * Lop abstract sinh ra de dinh nghia cac phuong thuc ma cac state deu co.
 */
public abstract class GameState {
    private static GameState currentState = null;

    protected Game game;

    public GameState(Game game){
        this.game = game;
    }

    public static void setCurrentState(GameState state) {
        currentState = state;
    }

    public static GameState getCurrentState() {
        return currentState;
    }

    public abstract void update();

    public abstract void render(Graphics g);

}
