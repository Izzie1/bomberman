package com.izzist.game.states;

import com.izzist.game.ultility.KeyHandler;

import java.awt.*;

public class GameStateManager {

    private GameState[] states;

    public static final int MENU = 0;
    public static final int PLAY = 1;
    public static final int PAUSE = 2;
    public static final int GAMEOVER = 3;

    public GameStateManager() {
        states = new GameState[4];
        states[MENU] = new MenuState(this);
    }

    public void add(int state) {
        if (states[state] != null) {
            return;
        }
        switch (state) {
            case MENU:
                states[MENU] = new MenuState(this);
                break;
            case PLAY:
                states[PLAY] = new PlayState(this);
                break;
            case PAUSE:
                states[PAUSE] = new PauseState(this);
                break;
            case GAMEOVER:
                states[GAMEOVER] = new GameoverState(this);
                break;
        }
    }

    public void pop(int state) {
        states[state] = null;
    }

    public void addAndPop(int state) {
        addAndPop(state, 0);
    }

    public void addAndPop(int state, int remove) {
        pop(state);
        add(state);
    }

    public void update() {
        for (int i = 0; i < states.length; i++) {
            if (states[i]!=null){
                states[i].update();
            }
        }
    }

    public void input(KeyHandler key) {
        for (int i = 0; i < states.length; i++) {
            if (states[i]!=null){
                states[i].input(key);
            }
        }
    }

    public void render(Graphics2D g2D) {
        for (int i = 0; i < states.length; i++) {
            if (states[i]!=null){
                states[i].render(g2D);
            }
        }
    }
}
