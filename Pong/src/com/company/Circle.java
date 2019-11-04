package com.company;

import java.awt.*;

public class Circle {
    private int centerX, centerY, radius;
    private Color color;

    //Fill constructors for the Circle
    public Circle(int x, int y, int r, Color c){
        centerX = x;
        centerY = y;
        radius = r;
        color = c;
    }
    //Default constructor for Circle
    public Circle(){
        centerX = 200;
        centerY = 200;
        radius = 10;
        color = Color.WHITE;
    }
    //Method to draw the circle as an outline
    public void draw(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(color);
        g.drawOval(centerX - radius, centerY - radius, radius*2, radius*2);
        g.setColor(oldColor);
    }
    //Method to draw the circle filled in
    public void fill(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillOval(centerX - radius, centerY - radius, radius*2, radius*2);
        g.setColor(oldColor);
    }
    //Check if the circle contains a point
    public boolean containsPoint(int x, int y){
        int xSquared = (int)Math.pow(x-centerX, 2);
        int ySquared = (int)Math.pow(y-centerY, 2);
        int radiusSquared = (int)Math.pow(radius, 2);
        return xSquared + ySquared - radiusSquared <=0;
    }
    //Method to move the circle by a certain offset
    public void move(int xAmount, int yAmount){
        centerX = centerX + xAmount;
        centerY = centerY - yAmount;
    }
    //Getters and Setters
    public int getCenterX() {
        return centerX;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
