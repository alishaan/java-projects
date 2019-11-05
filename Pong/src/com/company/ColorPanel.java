package com.company;

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel {
    private Ball ball;
    private Paddle paddle;
    private javax.swing.Timer timer;

    //Fill constructor
    public ColorPanel(Color backColor, int width, int height){
        setPreferredSize(new Dimension(width, height));
        setBackground(backColor);
       //Ball will be centered in the panel with a radius of 10
       ball = new Ball(90, 6, width/2, height/2, 10, Color.RED);
       paddle = new Paddle(width/2 - 75, height-100, 150, 12, Color.BLACK);
       timer = new javax.swing.Timer(33, actionEvent -> {
           ball.move();
           repaint();
       });
       timer.start();
    }

    //Default constructor
    public ColorPanel(){
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        //Ball will be centered in the panel with a radius of 10
        ball = new Ball(180, 6, 400/2, 400/2, 10, Color.RED);
        paddle = new Paddle(400/2 - 75, 400-100, 150, 12, Color.BLACK);
        timer = new javax.swing.Timer(33, actionEvent -> {
            ball.move();
            repaint();
        });
        timer.start();
    }

    //create paint component function
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ball.fill(g);
        paddle.draw(g);
    }

}
