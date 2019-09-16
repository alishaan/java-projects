package com.company;

//Imports
//For Color
import java.awt.*;
//For gui
import javax.swing.*;
//For click input
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TriangleTester {
    public static void main(String[] args) { //main class
        //Creating new gui for this project
        JFrame gui = new JFrame();
        //Creating a new panel to display the coordinate system on
        JPanel coordinate = new ColorPanel();
        //Creating a new panel to display the triangle data on
        JPanel trianglePanel = new JPanel();
        //Creating SplitPanel with the two Panels to split the view
        JSplitPane splitPanel = new JSplitPane(SwingConstants.VERTICAL, coordinate, trianglePanel);
        splitPanel.setResizeWeight(0.7);
        //Getting user input for coordinate plane
        gui.add(splitPanel);
        gui.setSize(1600, 900);
        gui.setVisible(true);
        coordinate.addMouseListener(new MouseAdapter() {
            int numberClicks = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //Creating an array for the x and y values of the clicks
                int[] arrX = new int[3];
                int[] arrY = new int[3];
                if (numberClicks == 3) {
                    numberClicks = 1;
                    arrX[numberClicks - 1] = e.getX();
                    arrY[numberClicks - 1] = e.getY();
                    numberClicks++;
                }else{
                    numberClicks++;
                    arrX[numberClicks - 1] = e.getX();
                    arrY[numberClicks - 1] = e.getY();
                }
            }
        });
    }
}
