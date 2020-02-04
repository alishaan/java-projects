package com.company;

import java.awt.*;

public class Paddle extends Rectangle {
    private Color color;
    //Fill constructor
    public Paddle(int x, int y, int width, int height, Color c){
        super(x, y, width, height);
        color = c;
    }
    //Default constructor
    public Paddle(){
        super();
        color = Color.BLACK;
    }

    //Function to move the paddle by a integer on the x-axis
    public void move(int xMove){
        x += xMove;
    }

    //fill method
    public void fill(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillRect(x, y, width, height);
        g.setColor(oldColor);
    }
    //draw method
    public void draw(Graphics g){
        Color oldColor = g.getColor();
        g.setColor(color);
        g.drawRect(x, y, width, height);
        g.setColor(oldColor);
    }
}
