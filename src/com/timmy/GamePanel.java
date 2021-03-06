package com.timmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Ball gameBall= new Ball();
    private Computer cPaddle = new Computer(this);
    private Player hPaddle = new Player();
    protected int gameSpeed = 50;  //How many milliseconds between clock ticks? Reduce this to speed up game
    static Timer gameTimer;

    GamePanel() {
        gameTimer = new Timer(gameSpeed, this);
        gameTimer.start();

        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    private void displayInstructions(Graphics g) {
        g.drawString("Pong! Press up or down to move", 20, 30);
        g.drawString("Press q to quit", 20, 60);
    }

    private void displayGame(Graphics g) {
        gameBall.paintBall(g);
        cPaddle.paintComputerPaddle(g);
        hPaddle.paintUserPaddle(g);
    }

    private void displayGameOver(Graphics g) {
        g.clearRect(200, 100, 200, 200);
        g.drawString("GAME OVER!", 50, 25);
    }

    private void update() {

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Gets the game's current state from Main */
        int gameState = Game.getGameState();

        /* Switch to display the different parts of the game */
        switch (gameState) {
            /* GAME_START */
            case 1: {
            /* Displays the instructions at the beginning of the game */
                displayInstructions(g);
                break;
            }
            /* GAMEPLAY */
            case 2: {
            /* Displays the game components while game is being played */
                displayGame(g);
                break;
            }
            /* GAME_OVER */
            case 3: {
            /* Displayed at the end of game */
                displayGameOver(g);
                break;
            }
        }
    }


    /* ActionListener */
    @Override
    public void actionPerformed(ActionEvent event) {
        gameBall.moveBall();
        cPaddle.moveComputerPaddle();
        if (Game.getGameState() == Game.GAME_OVER) {
            gameTimer.stop();
        }
        this.repaint();
    }

    @Override
    public void keyTyped(KeyEvent event) {
        char keyPressed = event.getKeyChar();
        char q = 'q';
        if( keyPressed == q){
            System.exit(0);    //quit if user presses the q key.
        }
    }

    @Override
    public void keyPressed(KeyEvent event) {

        /* If the game's current state is at GAME_START, then start it by setting the game state to GAMEPLAY */
        if (Game.getGameState() == Game.GAME_START) {
            Game.setGameState(Game.GAMEPLAY);
            this.repaint();
            return;
        }

        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down key");
            moveDown();
        }
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up key");
            moveUp();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent event) {}

    private void moveDown() {
        //Coordinates decrease as you go up the screen, that's why this looks backwards.
        int humanPaddleY = hPaddle.getUserPaddleY();
        int paddleSize = Player.getPaddleSize();
        int humanPaddleMaxSpeed = hPaddle.getHumanPaddleMaxSpeed();

        if (humanPaddleY < Game.HEIGHT - paddleSize) {
            humanPaddleY+=humanPaddleMaxSpeed;
            hPaddle.setUserPaddleY(humanPaddleY);
        }
    }

    private void moveUp() {
        //Coordinates increase as you go down the screen, that's why this looks backwards.
        int humanPaddleY = hPaddle.getUserPaddleY();
        int paddleSize = Player.getPaddleSize();
        int humanPaddleMaxSpeed = hPaddle.getHumanPaddleMaxSpeed();

        if (humanPaddleY > paddleSize) {
            humanPaddleY-=humanPaddleMaxSpeed;
            hPaddle.setUserPaddleY(humanPaddleY);
        }
    }

}
