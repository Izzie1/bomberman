package com.izzist.game;


import com.izzist.game.input.KeyHandler;
import com.izzist.game.sprite.Sprite;
import com.izzist.game.states.GameState;
import com.izzist.game.states.MenuState;
import com.izzist.game.states.PlayState;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Ham co chuc nang chinh cua game bao gom run, start , stop , GameLoop.
 */
public class Game implements Runnable {

    private Window window;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private GameState playState;//State
    private GameState menuState;

    private KeyHandler keyHandler;

    /**
     * Ham khoi tao.
     * @param title  Nhan de cua game
     * @param width  do rong man hinh
     * @param height chieu cao man hinh
     */
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyHandler = new KeyHandler();
    }

    private void init() {
        window = new Window(title, width, height);
        window.getFrame().addKeyListener(keyHandler);
        Sprite.init();


        playState = new PlayState(this);
        menuState = new MenuState(this);
        GameState.setCurrentState(playState);
    }


    /**
     * Ham update.
     */
    private void update() {
        if (GameState.getCurrentState() != null) {
            GameState.getCurrentState().update();
        }
    }

    /**
     * Ham render.
     */
    private void render() {
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Draw Here!

        g.fillRect(0, 0, width, height);
        if (GameState.getCurrentState() != null) {
            GameState.getCurrentState().render(g);
        }

        //End Drawing!
        bs.show();
        g.dispose();
    }

    /**
     * GameLoop.
     */
    public void run() {

        init();

        int FPS = 60;
        double timePerTick = 1000000000 / FPS;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                update();
                render();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }

    public KeyHandler getKeyHandler(){
        return keyHandler;
    }

    /**
     * Ham chay thread.
     */
    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Ham dong thread.
     */
    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight(){
        return height;
    }
}