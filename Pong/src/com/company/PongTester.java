package com.company;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PongTester {

    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        JFrame frame = new JFrame();
        ColorPanel view = new ColorPanel(Color.WHITE, 1200, 800);
        frame.setSize(new Dimension(1200, 800));
        frame.add(view);
        frame.setVisible(true);
        view.setVisible(true);
    }
}
