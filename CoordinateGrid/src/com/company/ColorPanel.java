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

        //initialize parent paint component
        super.paintComponent(g);
        g.setColor(Color.blue);
        //Graphics 2D is better for creating these gridlines and having them scale
        Graphics2D g2 = (Graphics2D) g;

        // Grid properties.
        g2.setColor(new Color(100, 100, 100));
        g2.setStroke(new BasicStroke(1));
        // Create grid lines.
        for (int i = 0; i < getWidth(); i+=12) {
            g2.drawLine(i, 0, i, getHeight());
            g2.drawLine(0, i, getWidth(), i);
        }

        //The color of the axises and their size
        g2.setColor(Color.black);
        g2.setStroke(new BasicStroke(3));
        // Create axis lines.
        g2.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
        g2.drawLine(0, getHeight()/2, getWidth(), getHeight()/2);


        //Text Color
        g.setColor(Color.black);
        //Text for the Origin, static
        g.drawString("(0, 0)", getWidth()/2 + 15, (getHeight()/2) - 10);
        //For Coordinates
        g.drawString(coordinateToString, xCo + 10, yCo - 10);

        //Color for the point
        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(5));
        //Creating origin point
        g2.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2);
        //Creating point compared to user click
        g2.drawLine(xCo, yCo, xCo, yCo);

    }
}