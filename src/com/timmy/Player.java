package com.timmy;

public class Player {

    private static final int paddleSize = 25;     //Actually half the paddle size - how much to draw on each side of center
    private static final int paddleDistanceFromSide = 10;  //How much space between each paddle and side of screen

    private int humanPaddleY = Game.HEIGHT / 2 ;
    private static int humanPaddleMaxSpeed = 5;   //This doesn't quite do the same thing... this is how many pixels human moves per key press TODO use this in a better way
    private static int humanPaddleSpeed = 0;      // "speed" is pixels moved up or down per clock tick

    Player() {

    }

}
