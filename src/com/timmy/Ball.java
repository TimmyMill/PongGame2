package com.timmy;

import java.awt.*;

public class Ball {

    protected final int ballSize = 25;                //Diameter of ball
    protected final double ballSpeed = 5;   //Again, pixels moved per clock tick
    private int ballX = Game.WIDTH / 2;   //Imagine the ball is in a square box. These are the coordinates of the top of that box.
    private int ballY = Game.HEIGHT / 2;   //So this starts the ball in (roughly) the center of the screen
    protected double ballDirection = Math.PI + 1;   //heading left and up

    /* Get & Set */
    public int getBallX() {return ballX;}
    public int getBallY() {return ballY;}
    public int getBallSize() {return ballSize;}
    public double getBallSpeed() {return ballSpeed;}
    public double getBallDirection() {return ballDirection;}

    void paintBall(Graphics g) {
        int x = getBallX();
        int y = getBallY();
        int ballSize = getBallSize();

        /* Ball - a circle is just an oval with the height equal to the width */
        g.setColor(Color.GREEN);
        g.fillOval(x, y, ballSize, ballSize);
    }

    void moveBall() {
        //move in current direction
        //bounce off walls and paddle
        //TODO Take into account speed of paddles

        boolean hitWall = false;
        boolean hitHumanPaddle = false;
        boolean hitComputerPaddle = false;

        if (ballX <= 0 || ballX >= Game.WIDTH ) {
            Game.setGameState(Game.GAME_OVER);
            return;
        }

        if (ballY <= 0 || ballY >= Game.HEIGHT-ballSize) {
            hitWall = true;
        }

        //If ballX is at a paddle AND ballY is within the paddle size.
        //Hit human paddle?
        Player hPaddle = new Player();
        int humanPaddleY = hPaddle.getUserPaddleY();
        int paddleDistanceFromSide = Player.getPaddleDistanceFromSide();
        int paddleSize = Player.getPaddleSize();

        if (ballX >= Game.HEIGHT-(paddleDistanceFromSide+(ballSize)) && (ballY >humanPaddleY-paddleSize && ballY < humanPaddleY+paddleSize))
            hitHumanPaddle = true;

        //Hit computer paddle?
        Computer cPaddle = new Computer(new GamePanel());
        int computerPaddleY = cPaddle.getComputerPaddleY();
        paddleDistanceFromSide = Computer.getPaddleDistanceFromSide();
        paddleSize = Computer.getPaddleSize();

        if (ballX <= paddleDistanceFromSide && (ballY > computerPaddleY-paddleSize && ballY < computerPaddleY+paddleSize))
            hitComputerPaddle = true;

        if (hitWall) {
            //bounce
            ballDirection = ( (2 * Math.PI) - ballDirection );
            System.out.println("ball direction " + ballDirection);
        }

        //Bounce off computer paddle - just need to modify direction
        if (hitComputerPaddle) {
            ballDirection = (Math.PI) - ballDirection;
            //TODO factor in speed into new direction
            //TODO So if paddle is moving down quickly, the ball will angle more down too
        }

        //Bounce off computer paddle - just need to modify direction
        if (hitHumanPaddle) {
            ballDirection = (Math.PI) - ballDirection;
            //TODO consider speed of paddle
        }

        //Now, move ball correct distance in the correct direction

        // ** TRIGONOMETRY **

        //distance to move in the X direction is ballSpeed * cos(ballDirection)
        //distance to move in the Y direction is ballSpeed * sin(ballDirection)

        ballX = (int) (ballX + (ballSpeed * Math.cos(ballDirection)));
        ballY = (int) (ballY + (ballSpeed * Math.sin(ballDirection)));

        // ** TRIGONOMETRY END **
    }
}
