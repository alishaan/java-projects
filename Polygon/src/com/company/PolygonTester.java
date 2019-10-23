package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PolygonTester {

    public static int width;
    public static int height;
    public static ArrayList<Point> pointsList = new ArrayList<Point>();
    public static Polygon clickedPolygon = new Polygon();

    public static void main(String[] args) {

        //Creating new gui for this project
        JFrame gui = new JFrame();
        //Creating a new panel to display the coordinate system on
        JPanel coordinatePanel = new ColorPanel();
        //Creating a new panel to display the triangle data on
        JPanel polygonPanel = new JPanel();

        JButton b1 = new JButton("Restart");
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); //aka LEFT, for left-to-right locales
        b1.setMnemonic(KeyEvent.VK_D);
        b1.setActionCommand("disable");
        polygonPanel.add(b1);

        JTextArea polygonText = new JTextArea(clickedPolygon.toString());
        polygonText.setSize(new Dimension(300, 900));
        polygonText.setLineWrap(true);
        polygonText.setEditable(false);
        polygonPanel.add(polygonText);
        JSplitPane splitPanel = new JSplitPane(SwingConstants.VERTICAL, coordinatePanel, polygonPanel);
        splitPanel.setResizeWeight(0.7);
        //Getting user input for coordinate plane
        gui.add(splitPanel);
        gui.setSize(1600, 900);
        gui.setVisible(true);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // this makes sure the button you are pressing is the button variable
                pointsList = new ArrayList<Point>();
                clickedPolygon = new Polygon();
                coordinatePanel.repaint();
                polygonText.setText(clickedPolygon.toString());
            }
        });

        //Variables to see height and width
        width = coordinatePanel.getWidth();
        height = coordinatePanel.getHeight();
        //Adding mouse input to the coordinate pane
        coordinatePanel.addMouseListener(new MouseAdapter() {
            int numberClicks = 0;

            @Override
            public void mouseClicked(MouseEvent e) {
                width = coordinatePanel.getWidth();
                height = coordinatePanel.getHeight();
                numberClicks++;
                super.mouseClicked(e);
                //Add clicked point into an array
                pointsList.add(new Point(e.getX(), e.getY()));
                coordinatePanel.repaint();
                clickedPolygon = new Polygon(pointsList);
                polygonText.setText(clickedPolygon.toString());
            }
        });
        //Adding bar movement listener
        splitPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                width = coordinatePanel.getWidth();
                height = coordinatePanel.getHeight();
                polygonText.setText(clickedPolygon.toString());
                coordinatePanel.repaint();
            }
        });
        polygonPanel.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                width = coordinatePanel.getWidth();
                height = coordinatePanel.getHeight();

                polygonText.setText(clickedPolygon.toString());
                coordinatePanel.repaint();
            }
        });
    }
}
