package com.company;

import javax.swing.*;
import java.awt.*;

public class PongTester {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ColorPanel view = new ColorPanel(Color.WHITE, 1200, 800);
        frame.setSize(new Dimension(1200, 800));
        frame.add(view);
        frame.setVisible(true);
        view.setVisible(true);
    }
}
