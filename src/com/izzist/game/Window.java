package com.izzist.game;

import com.izzist.game.graphics.Sprite;

import javax.swing.JFrame;

/**
 * Hien cua so cua game
 */
public class Window extends JFrame {
    public Window() {
        Sprite.init();
        setTitle("Bomberman");
        setIconImage(Sprite.Icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(32 * 31, 32 * 20));
        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
