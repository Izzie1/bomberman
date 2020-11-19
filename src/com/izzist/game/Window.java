package com.izzist.game;


import javax.swing.*;
import java.awt.*;

/**
 * Lop Window dung de tao ra cua so cua game.
 */
public class Window {
    private JFrame frame;
    private Canvas canvas;

    private String title;

    private int width;
    private int height;

    /**
     * Constructor khoi tao window.
     * @param title Nhan de cua chuong trinh
     * @param width Do rong man hinh
     * @param height Chieu cao man hinh
     */
    public Window(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        display();
    }

    /**
     * Set window hien thi.
     */
    private void display(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
