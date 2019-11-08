package com.company;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class PongPanel extends JPanel {
    private Ball ball;
    private Paddle paddle;
    private javax.swing.Timer timer;
    private int buttonPosition;
    private ArrayList<Block> blocksList = new ArrayList<>();
    private Player player;
    private int timeWithoutBallHit;
    private JLabel score;
    private AudioInputStream as = AudioSystem.getAudioInputStream(new File("src/ChillingMusic.wav").getAbsoluteFile());
    private BufferedImage image;

    //Fill constructor
    public PongPanel(Color backColor, int width, int height) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        Clip clip = AudioSystem.getClip();
        clip.open(as);
        clip.start();

        player = new Player();
        for (int i = 0; i<20; i++){
            blocksList.add(new Block(i*(width/20), height/25, width/20, height/20, Color.ORANGE, false));
            blocksList.add(new Block(i*(width/20), height/25+(height/20), width/20, height/20, Color.GREEN, false));
            blocksList.add(new Block(i*(width/20), height/25+(height/10), width/20, height/20, Color.RED, false));
        }
        buttonPosition = 0;
        setPreferredSize(new Dimension(width, height));
        setBackground(backColor);
       //Ball will be centered in the panel with a radius of 10
        ball = new Ball(90, 10, width/2, height/2, 7, Color.RED);
        paddle = new Paddle(width/2 - 75, height-100, 150, 25, Color.BLACK);
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

        //Mouse input
        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseMoved(MouseEvent mouseEvent) {
                paddle.setLocation(mouseEvent.getX() - (int)paddle.getWidth()/2, (int)paddle.getY());
            }
        });
        //Scoreboard
        score = new JLabel(String.valueOf(player.getScore()));
        add(score);
    }

    //Default constructor
    public PongPanel() throws IOException, UnsupportedAudioFileException {
        player = new Player();
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
        //Ball will be centered in the panel with a radius of 10
        ball = new Ball(180, 10, 400/2, 400/2, 10, Color.RED);
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

        timeWithoutBallHit++;

        try {
            image = ImageIO.read(new File("src/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(image, getWidth()/2 - image.getWidth()/2, getHeight()/2 - image.getHeight()/2, this);

        if(buttonPosition == 1){
            paddle.move(-20);
        }else if (buttonPosition == 2){
            paddle.move(20);
        }
        ball.fill(g);
        paddle.draw(g);
        buttonPosition = 0;

        //Detection of paddle collision
        if(paddle.contains(ball.getCenterX(), ball.getCenterY())){
            ball.setDirection(135 + (int)(Math.random() * ((180 - 135) + 1)) + ball.getDirection());
        }
        //Detection of block collision
        for (int i = 0; i<blocksList.size(); i++){
            if (blocksList.get(i).contains(ball.getCenterX(), ball.getCenterY())&&!blocksList.get(i).isDestroyed){
                if (Math.abs(blocksList.get(i).getY() - ball.getCenterY()) > Math.abs(blocksList.get(i).getX()
                        - ball.getCenterX()) || Math.abs(blocksList.get(i).getY() - ball.getCenterY()) >
                        Math.abs(blocksList.get(i).getX() + blocksList.get(i).getWidth() - ball.getCenterX())){
                    ball.setDirection(360 - ball.getDirection());
                }else{
                    ball.setDirection(180 - ball.getDirection());
                }
                blocksList.get(i).setDestroyed(true);
                timeWithoutBallHit = 0;
                player.addPoints(100);
                score.setText(String.valueOf(player.getScore()));
            }
        }
        //Draws all blocks that are not destroyed
        for (int i = 0; i<blocksList.size(); i++){
            blocksList.get(i).fill(g);
        }
        //Test for collision with the walls
        if (ball.getCenterX() <= 0 || ball.getCenterX() >= getWidth()){
            ball.setDirection(180-ball.getDirection());
        }else if (ball.getCenterY() <= 0){
            ball.setDirection(360-ball.getDirection());
        }
        //Test condition if ball hits the bottom of the screen
        else if (ball.getCenterY() >= getHeight()){
            timer.stop();
            g.setFont(new Font("TimesRoman", Font.BOLD, 100));
            g.drawString("You Lost", getWidth()/2 - 200, getHeight()/2-200);
        }
        ball.setVelocity(16+timeWithoutBallHit/10);

        if (player.getScore() == 6000){
            timer.stop();
            g.setFont(new Font("TimesRoman", Font.BOLD, 100));
            g.drawString("You Won", getWidth()/2 - 200, getHeight()/2-200);
        }
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getButtonPosition() {
        return buttonPosition;
    }

    public void setButtonPosition(int buttonPosition) {
        this.buttonPosition = buttonPosition;
    }

    public ArrayList<Block> getBlocksList() {
        return blocksList;
    }

    public void setBlocksList(ArrayList<Block> blocksList) {
        this.blocksList = blocksList;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getTimeWithoutBallHit() {
        return timeWithoutBallHit;
    }

    public void setTimeWithoutBallHit(int timeWithoutBallHit) {
        this.timeWithoutBallHit = timeWithoutBallHit;
    }

    public JLabel getScore() {
        return score;
    }

    public void setScore(JLabel score) {
        this.score = score;
    }

    public AudioInputStream getAs() {
        return as;
    }

    public void setAs(AudioInputStream as) {
        this.as = as;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
}
