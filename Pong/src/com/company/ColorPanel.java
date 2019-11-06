package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ColorPanel extends JPanel {
    private Ball ball;
    private Paddle paddle;
    private javax.swing.Timer timer;
    private int buttonPosition;
    private ArrayList<Block> blocksList = new ArrayList<>();

    //Fill constructor
    public ColorPanel(Color backColor, int width, int height){
        for (int i = 0; i<20; i++){
            blocksList.add(new Block(i*(width/15), height/25, width/5, height/20, Color.BLACK, false));
            blocksList.add(new Block(i*(width/15), height/25+(height/20), width/5, height/20, Color.BLACK, false));
            blocksList.add(new Block(i*(width/15), height/25+(height/10), width/5, height/20, Color.BLACK, false));
        }
        buttonPosition = 0;
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

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");

        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPosition = 1;
            }
        });
        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPosition = 2;
            }
        });
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

        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "left");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "right");

        am.put("left", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPosition = 1;
            }
        });
        am.put("right", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPosition = 2;
            }
        });
    }

    //create paint component function
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(buttonPosition == 1){
            paddle.move(-10);
        }else if (buttonPosition == 2){
            paddle.move(10);
        }
        for (int i = 0; i<blocksList.size(); i++){
            blocksList.get(i).draw(g);
        }
        ball.fill(g);
        paddle.draw(g);
        buttonPosition = 0;
    }

}
