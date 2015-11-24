package com.timmy;

public class Ball {

    protected final int ballSize = 10;                //Diameter of ball
    protected final double ballSpeed = 5;   //Again, pixels moved per clock tick
    private int ballX = Game.WIDTH / 2;   //Imagine the ball is in a square box. These are the coordinates of the top of that box.
    private int ballY = Game.HEIGHT / 2;   //So this starts the ball in (roughly) the center of the screen
    protected double ballDirection = Math.PI + 1;   //heading left and up

    Ball(int ballX, int ballY) {
        this.ballX = ballX;
        this.ballY = ballY;
    }

    public int getBallX() {return ballX;}
    public int getBallY() {return ballY;}
    public int getBallSize() {return ballSize;}
    public double getBallSpeed() {return ballSpeed;}
    public double getBallDirection() {return ballDirection;}

    protected void moveBall() {
        //move in current direction
        //bounce off walls and paddle
        //TODO Take into account speed of paddles

        boolean hitWall = false;
        boolean hitHumanPaddle = false;
        boolean hitComputerPaddle = false;

        if (ballX <= 0 || ballX >= Game.WIDTH ) {
            return;
        }

        if (ballY <= 0 || ballY >= Game.HEIGHT-ballSize) {
            hitWall = true;
        }


    }
}
