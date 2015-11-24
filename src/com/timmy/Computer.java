package com.timmy;

import java.awt.*;

public class Computer {

    private static final int paddleSize = 25;     //Actually half the paddle size - how much to draw on each side of center
    private static final int paddleDistanceFromSide = 10;  //How much space between each paddle and side of screen

    protected int computerPaddleY = Game.HEIGHT / 2 ;
    protected int computerPaddleMaxSpeed = 3;   //Max number of pixels that computer paddle can move clock tick. Higher number = easier for computer
    protected static int computerPaddleSpeed = 0;   // same

    protected GamePanel panel;

    Computer(GamePanel panel) {
        this.panel = panel;
    }

    public static int getPaddleSize() {return paddleSize;}
    public static int getPaddleDistanceFromSide() {return paddleDistanceFromSide;}

    public int getComputerPaddleY() {return computerPaddleY;}
    public void setComputerPaddleY(int computerPaddleY) {this.computerPaddleY = computerPaddleY;}

    public int getComputerPaddleMaxSpeed() {return computerPaddleMaxSpeed;}
    public static int getComputerPaddleSpeed() {return computerPaddleSpeed;}

    void paintComputerPaddle(Graphics g) {
        int computerPaddleY = getComputerPaddleY();
        int paddleSize = getPaddleSize();
        int paddleDistanceFromSide = getPaddleDistanceFromSide();

        /* Computer paddle */
        g.setColor(Color.black);
        g.drawLine(paddleDistanceFromSide, computerPaddleY - paddleSize, paddleDistanceFromSide, computerPaddleY + paddleSize);
    }

    //Uses the current position of ball and paddle to move the computer paddle towards the ball
    protected void moveComputerPaddle() {

        //if ballY = 100 and paddleY is 50, difference = 50, need to adjust
        //paddleY by up to the max speed (the minimum of difference and maxSpeed)

        //if ballY = 50 and paddleY = 100 then difference = -50
        //Need to move paddleY down by the max speed
        Ball ball = new Ball(); //create a new ball to get BallY
        double ballY = ball.getBallY();

        Computer cPaddle = new Computer(this.panel);

        int computerPaddleY = cPaddle.getComputerPaddleY();
        double ballPaddleDifference = computerPaddleY - ballY;
        double distanceToMove = Math.min(Math.abs(ballPaddleDifference), cPaddle.getComputerPaddleMaxSpeed());

        if (ballPaddleDifference > 0) {   //Difference is positive - paddle is below ball on screen
            computerPaddleY -= distanceToMove;
            cPaddle.setComputerPaddleY(computerPaddleY);
        } else if (ballPaddleDifference < 0) {
            computerPaddleY += distanceToMove;
            cPaddle.setComputerPaddleY(computerPaddleY);
        } else {
            //Ball and paddle are aligned. Don't need to move!
            computerPaddleSpeed = 0;
        }

    }
}
