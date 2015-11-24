package com.timmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Ball gameBall = new Ball(Game.HEIGHT / 2, Game.WIDTH / 2);
    private Computer cPaddle = new Computer();
    private Player hPaddle = new Player();

    GamePanel() {

        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

    @Override
    public void actionPerformed(ActionEvent event) {

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
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down key");
            moveDown();
        }
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up key");
            moveUp();
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {}

    private void moveDown() {
        //Coordinates decrease as you go up the screen, that's why this looks backwards.
        int humanPaddleY = hPaddle.getHumanPaddleY();
        int paddleSize = Player.getPaddleSize();
        int humanPaddleMaxSpeed = hPaddle.getHumanPaddleMaxSpeed();

        if (humanPaddleY < Game.HEIGHT - paddleSize) {
            humanPaddleY+=humanPaddleMaxSpeed;
            hPaddle.setHumanPaddleY(humanPaddleY);
        }
    }

    private void moveUp() {
        //Coordinates increase as you go down the screen, that's why this looks backwards.
        int humanPaddleY = hPaddle.getHumanPaddleY();
        int paddleSize = Player.getPaddleSize();
        int humanPaddleMaxSpeed = hPaddle.getHumanPaddleMaxSpeed();

        if (humanPaddleY > paddleSize) {
            humanPaddleY-=humanPaddleMaxSpeed;
            hPaddle.setHumanPaddleY(humanPaddleY);
        }
    }
}
