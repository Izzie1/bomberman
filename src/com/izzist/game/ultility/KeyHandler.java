package com.izzist.game.ultility;

import com.izzist.game.GamePanel;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * xu ly cac thao tac nhap xua tu ban phim.
 */
public class KeyHandler implements KeyListener {

    public static List<Key> keys = new ArrayList<Key>();

    public class Key {
        public int presses;
        public int absorbs;
        public boolean down;
        public boolean clicked;

        public Key() {
            keys.add(this);
        }

        public void toggle(boolean pressed) {
            if (pressed != down) {
                down = pressed;
            }
            if (pressed) {
                presses++;
            }
        }

        public void tick() {
            if (absorbs == presses) {
                clicked = false;
            } else {
                absorbs++;
                clicked = true;
            }
        }
    }

    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public Key attack = new Key();
    public Key enter = new Key();
    public Key clear = new Key();
    public Key cheat1 = new Key();
    public Key cheat2 = new Key();

    public KeyHandler(GamePanel game) {
        game.addKeyListener(this);
    }


    public void toggle(KeyEvent e, boolean pressed) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up.toggle(pressed);
                break;
            case KeyEvent.VK_DOWN:
                down.toggle(pressed);
                break;
            case KeyEvent.VK_LEFT:
                left.toggle(pressed);
                break;
            case KeyEvent.VK_RIGHT:
                right.toggle(pressed);
                break;
            case KeyEvent.VK_SPACE:
                attack.toggle(pressed);
                break;
            case KeyEvent.VK_ENTER:
                enter.toggle(pressed);
                break;
            case KeyEvent.VK_7:
                clear.toggle(pressed);
                break;
            case KeyEvent.VK_8:
                cheat1.toggle(pressed);
                break;
            case KeyEvent.VK_9:
                cheat2.toggle(pressed);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }
}
