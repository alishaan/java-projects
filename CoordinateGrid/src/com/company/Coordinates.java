package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Coordinates {

    //Variables referenced in both classes and therefore are declared before the main class
    public static int xCo = -5;
    public static int yCo = -5;
    public static String coordinateToString = "";

    public static void main(String[] args) {
        //Declaring the JFrame and new panels
        JFrame gui = new JFrame();
        ColorPanel pane = new ColorPanel(new Color(255, 255, 255));

        //Setting GUI properties
        gui.setSize(600, 600);
        gui.add(pane);

        gui.setVisible(true);

        //This is where we get mouse input from the user
        pane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                xCo = e.getX();
                yCo = e.getY();

                coordinateToString = "(" + (((pane.getWidth() / 2) - xCo) * -1) + ", " + ((pane.getHeight() / 2) - yCo) + ")";
                pane.repaint();
            }
        });
    }

    static class ColorPanel extends JPanel{
        //default constructor
        public ColorPanel(){
            setBackground(Color.white);
        }
        //fill constructor
        public ColorPanel(Color backColor){
            setBackground(backColor);
        }
        public void paintComponent(Graphics g) {
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
}
