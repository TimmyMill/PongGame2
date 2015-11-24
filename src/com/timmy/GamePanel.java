package com.timmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private Ball gameBall;

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
        char keyType = event.getKeyChar();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down key");
//            moveDown();
        }
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("up key");
//            moveUp();
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {}
}
