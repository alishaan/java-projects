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
    //Arrays of points
    public static int[] arrX = new int[]{0, 0, 0};
    public static int[] arrY = new int []{0, 0, 0};
    private static int width;
    private static int height;
    //Coordinate points to access in other classes
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
        //Setting origin values to initial points of triangle
        arrX[0] =  coordinate.getWidth()/2;
        arrX[1] =  coordinate.getWidth()/2;
        arrX[2] =  coordinate.getWidth()/2;
        arrY[0] =  coordinate.getHeight()/2;
        arrY[1] =  coordinate.getHeight()/2;
        arrY[2] =  coordinate.getHeight()/2;

        //Variables to see height and width
        width = coordinate.getWidth();
        height = coordinate.getHeight();
        coordinate.addMouseListener(new MouseAdapter() {
            int numberClicks = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                numberClicks++;
                super.mouseClicked(e);
                //Creating an array for the x and y values of the clicks
                if (numberClicks == 4) {
                    numberClicks = 1;
                    arrX[numberClicks - 1] = e.getX();
                    arrY[numberClicks - 1] = e.getY();
                    coordinate.repaint();
                }else{
                    arrX[numberClicks - 1] = e.getX();
                    arrY[numberClicks - 1] = e.getY();
                    coordinate.repaint();
                }
            }
        });
    }
    //Getters for the arrays of points
    public static int[] getArrX() {
        return arrX;
    }

    public static int[] getArrY() {
        return arrY;
    }
    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }
}
