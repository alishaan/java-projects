package com.company;

import java.awt.*;

public class Block extends Rectangle {
    //Data specific to Block Class
    private Color color;
    boolean isDestroyed;

    //Fill Constructor
    public Block(int x, int y, int width, int height, Color c, boolean id){
        super(x, y, width, height);
        color = c;
        isDestroyed = id;
    }
    //Default Constructor
    public Block(){
        super();
        color = Color.BLACK;
        isDestroyed = false;
    }

    //Methods to draw and or fill the polygon
    public void fill(Graphics g){
        if (isDestroyed == false){
            Color oldColor = g.getColor();
            g.setColor(color);
            g.fillRect(x, y, width, height);
            g.setColor(oldColor);
        }
    }
    //draw method
    public void draw(Graphics g){
        if (isDestroyed == false){
            Color oldColor = g.getColor();
            g.setColor(color);
            g.drawRect(x, y, width, height);
            g.setColor(oldColor);
        }
    }

}
