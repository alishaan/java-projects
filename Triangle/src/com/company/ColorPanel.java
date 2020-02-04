package com.company;

//Import Gui
import javax.swing.*;
//Import color
import java.awt.*;

public class ColorPanel extends JPanel {
    public Triangle clickedTriangle = new Triangle();
    //default constructor
    public ColorPanel(){
        setBackground(Color.white);
    }
    //fill constructor
    public ColorPanel(Color backColor){
        setBackground(backColor);
    }
    public void paintComponent(Graphics g) {
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
        //Creating the Triangle
        clickedTriangle.setTriangle(new Triangle(new LineSeg(new Point(TriangleTester.arrX[0], TriangleTester.arrY[0]), new Point(TriangleTester.arrX[1], TriangleTester.arrY[1])), new LineSeg(new Point(TriangleTester.arrX[1], TriangleTester.arrY[1]), new Point(TriangleTester.arrX[2], TriangleTester.arrY[2])), new LineSeg(new Point(TriangleTester.arrX[0], TriangleTester.arrY[0]), new Point(TriangleTester.arrX[2], TriangleTester.arrY[2]))));
        // Draw label showing coordinates.
        g.drawString(clickedTriangle.getLineSeg1().getMyBP().toStringCommon(), TriangleTester.getArrX()[0] + 5, TriangleTester.getArrY()[0] - 5);
        g.drawString(clickedTriangle.getLineSeg1().getMyEP().toStringCommon(), TriangleTester.getArrX()[1] + 5, TriangleTester.getArrY()[1] - 5);
        g.drawString(clickedTriangle.getLineSeg2().getMyEP().toStringCommon(), TriangleTester.getArrX()[2] + 5, TriangleTester.getArrY()[2] - 5);
        // Point properties.
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(2));
        //Create point at the origin
        g2.drawLine(getWidth()/2, getHeight()/2, getWidth()/2, getHeight()/2);
        //Create point on clicks
        g2.drawLine(TriangleTester.getArrX()[0], TriangleTester.getArrY()[0], TriangleTester.getArrX()[1], TriangleTester.getArrY()[1]);
        g2.drawLine(TriangleTester.getArrX()[1], TriangleTester.getArrY()[1], TriangleTester.getArrX()[2], TriangleTester.getArrY()[2]);
        g2.drawLine(TriangleTester.getArrX()[2], TriangleTester.getArrY()[2], TriangleTester.getArrX()[0], TriangleTester.getArrY()[0]);
    }
}
