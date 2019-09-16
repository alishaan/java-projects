package com.company;

//Imports
//For Color
import java.awt.*;
//For gui
import javax.swing.*;
//For click input
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TriangleTester {
    public static void main(String[] args) { //main class
        //Creating new gui for this project
        JFrame gui = new JFrame();
        //Creating a new panel to display the coordinate system on
        JPanel coordinate = new JPanel();
        //Creating a new panel to display the triangle data on
        JPanel trianglePanel = new JPanel();
        //Creating SplitPanel with the two Panels to split the view
        JSplitPane splitPanel = new JSplitPane(SwingConstants.VERTICAL, coordinate, trianglePanel);
        gui.add(splitPanel);
        gui.setSize(1000, 1000);
        gui.setVisible(true);
    }
}
