package com.timmy;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    protected static final int WIDTH = 600, HEIGHT = 600;

    static final int GAME_START = 1;
    static final int GAMEPLAY = 2;
    static final int GAME_OVER = 3;
    protected static int gameState = GAME_START;

    protected GamePanel panel;

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
        setGameState(GAME_START);
    }

    public static int getGameState() {return gameState;}
    public static void setGameState(int gameState) {Game.gameState = gameState;}

    public static void main(String[] args) {
        new Game();
    }
}
