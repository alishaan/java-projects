package com.company;

import com.company.Coordinates;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    //default constructor
    public ColorPanel(){
        setBackground(Color.white);
    }
    //fill constructor
    public ColorPanel(Color backColor){
        setBackground(backColor);
    }
    public void paintComponent(Graphics g) {
        Coordinates Coordinates =  new Coordinates();

        String coordinateToString = Coordinates.coordinateToString;
        int xCo = Coordinates.xCo;
        int yCo = Coordinates.yCo;

        //initialize paint component
        super.paintComponent(g);
        g.setColor(Color.blue);
        // Create Graphics2D component.
        Graphics2D g2 = (Graphics2D) g;

        // Drawing grid first, then axis to overlay.

        // Grid properties.
        g2.setColor(new Color(206, 206, 206));
        g2.setStroke(new BasicStroke(1));
        // Create grid lines.
        for (int i = 0; i < getWidth(); i+=10) {
            g2.drawLine(i, 0, i, getHeight());
            g2.drawLine(0, i, getWidth(), i);
        }

        // Axis properties.
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        // Create axis lines.
        g2.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        g2.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);


        // Text properties.
        g.setColor(Color.black);
        // Draw label showing origin.
        g.drawString("(0, 0)", getWidth()/2 + 10, (getHeight()/2) - 5);
        // Draw label showing coordinates.
        g.drawString(coordinateToString, xCo + 5, yCo - 5);

        // Point properties.
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(5));
        // Create point at...
        // ...the origin
        g2.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2);
        // ...the user's click.
        g2.drawLine(xCo, yCo, xCo, yCo);
    }
}