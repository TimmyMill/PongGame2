package com.timmy;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    protected static final int WIDTH = 600, HEIGHT = 600;

    GamePanel panel;

    public Game() {
        /* JFrame settings for window */
        setSize(new Dimension(WIDTH, HEIGHT));
        setTitle("Pong");
        setBackground(Color.GRAY);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //JPane settings
        panel = new GamePanel();
        add(panel);
    }

    public static void main(String[] args) {
	// write your code here
    }
}
