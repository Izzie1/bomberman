package com.izzist.game;
/**
 * Class dung de chay game.
 */
public class Launcher {
    public static void main(String[] args) {
        Game game = new Game("bomberman",1024,800);
        game.start();
    }
}
