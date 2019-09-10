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
        //Declaring the JFrame and the Color Panels
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
}
