package com.company;

import java.awt.*;

public class Ball extends Circle{
    private int direction, velocity;
    //Fill constructor for Circle
    public Ball(int d, int v, int x, int y, int r, Color c){
        super(x, y, r, c);
        direction = d;
        velocity = v;
    }
    //Default constructor
    public Ball(){
        super();
        direction = 0;
        velocity = 0;
    }
    //Method to turn the angle of the ball by a certain number of degrees
    public void turn(int degrees){
        direction = (direction + degrees) % 360;
    }
    //Method to move the ball by utilizing velocity and direction
    public void move(){
        move((int)(velocity * Math.cos(Math.toRadians(direction))), (int)(velocity * Math.sin(Math.toRadians(direction))));
    }
    //Getters and Setters
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction % 360;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
