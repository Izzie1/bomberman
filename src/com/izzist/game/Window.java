package com.izzist.game;

import javax.swing.JFrame;

public class Window extends JFrame {
    public Window() {
        setTitle("bomberman");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(1280,800));
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }
}
