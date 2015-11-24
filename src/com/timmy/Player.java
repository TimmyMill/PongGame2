package com.timmy;

import java.awt.*;

public class Player {

    private static final int paddleSize = 25;     //Actually half the paddle size - how much to draw on each side of center
    private static final int paddleDistanceFromSide = 10;  //How much space between each paddle and side of screen

    private int userPaddleY = Game.HEIGHT / 2 ;
    protected static int userPaddleMaxSpeed = 5;   //This doesn't quite do the same thing... this is how many pixels human moves per key press TODO use this in a better way
    protected static int userPaddleSpeed = 0;      // "speed" is pixels moved up or down per clock tick

    void paintUserPaddle(Graphics g) {
        int humanPaddleY = getUserPaddleY();
        int paddleSize = getPaddleSize();
        int paddleDistanceFromSide = getPaddleDistanceFromSide();

        /* User paddle */
        g.setColor(Color.black);
        g.drawLine(Game.WIDTH - paddleDistanceFromSide, humanPaddleY - paddleSize, Game.WIDTH - paddleDistanceFromSide, humanPaddleY + paddleSize);
    }

    public static int getPaddleSize() {return paddleSize;}
    public static int getPaddleDistanceFromSide() {return paddleDistanceFromSide;}

    public int getUserPaddleY() {return userPaddleY;}
    public void setUserPaddleY(int userPaddleY) {this.userPaddleY = userPaddleY;}

    public int getHumanPaddleMaxSpeed() {return userPaddleMaxSpeed;}
    public static int getUserPaddleSpeed() {return userPaddleSpeed;}
}
