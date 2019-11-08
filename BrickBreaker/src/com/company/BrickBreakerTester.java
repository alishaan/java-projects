package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BrickBreakerTester {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        JFrame frame = new JFrame();
        PongPanel view = new PongPanel(Color.WHITE, 1200, 800);
        frame.setSize(new Dimension(1200, 800));
        frame.add(view);
        frame.setVisible(true);
        view.setVisible(true);
    }
}
