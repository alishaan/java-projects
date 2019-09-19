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
    public static Triangle clickedTriangle = new Triangle();
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
        JPanel coordinatePanel = new ColorPanel();
        //Creating a new panel to display the triangle data on
        JPanel trianglePanel = new JPanel();
        JTextArea triangleText = new JTextArea(clickedTriangle.toString());
        triangleText.setSize(new Dimension(300, 900));
        triangleText.setLineWrap(true);
        triangleText.setEditable(false);
        trianglePanel.add(triangleText);
        //Creating SplitPanel with the two Panels to split the view
        JSplitPane splitPanel = new JSplitPane(SwingConstants.VERTICAL, coordinatePanel, trianglePanel);
        splitPanel.setResizeWeight(0.7);
        //Getting user input for coordinate plane
        gui.add(splitPanel);
        gui.setSize(1600, 900);
        gui.setVisible(true);
        //Setting origin values to initial points of triangle
        arrX[0] =  coordinatePanel.getWidth()/2;
        arrX[1] =  coordinatePanel.getWidth()/2;
        arrX[2] =  coordinatePanel.getWidth()/2;
        arrY[0] =  coordinatePanel.getHeight()/2;
        arrY[1] =  coordinatePanel.getHeight()/2;
        arrY[2] =  coordinatePanel.getHeight()/2;
        //Variables to see height and width
        width = coordinatePanel.getWidth();
        height = coordinatePanel.getHeight();
        //Adding mouse input to the coordinate pane
        coordinatePanel.addMouseListener(new MouseAdapter() {
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
                    coordinatePanel.repaint();
                    clickedTriangle.setTriangle(new Triangle(new LineSeg(new Point(TriangleTester.arrX[0], TriangleTester.arrY[0]), new Point(TriangleTester.arrX[1], TriangleTester.arrY[1])), new LineSeg(new Point(TriangleTester.arrX[1], TriangleTester.arrY[1]), new Point(TriangleTester.arrX[2], TriangleTester.arrY[2])), new LineSeg(new Point(TriangleTester.arrX[0], TriangleTester.arrY[0]), new Point(TriangleTester.arrX[2], TriangleTester.arrY[2]))));
                    triangleText.setText(clickedTriangle.toString());
                }else{
                    arrX[numberClicks - 1] = e.getX();
                    arrY[numberClicks - 1] = e.getY();
                    coordinatePanel.repaint();
                    clickedTriangle.setTriangle(new Triangle(new LineSeg(new Point(TriangleTester.arrX[0], TriangleTester.arrY[0]), new Point(TriangleTester.arrX[1], TriangleTester.arrY[1])), new LineSeg(new Point(TriangleTester.arrX[1], TriangleTester.arrY[1]), new Point(TriangleTester.arrX[2], TriangleTester.arrY[2])), new LineSeg(new Point(TriangleTester.arrX[0], TriangleTester.arrY[0]), new Point(TriangleTester.arrX[2], TriangleTester.arrY[2]))));
                    triangleText.setText(clickedTriangle.toString());
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

    public Triangle getClickedTriangle() {
        return clickedTriangle;
    }
}
