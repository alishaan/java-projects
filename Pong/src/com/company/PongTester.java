package com.company;

import javax.swing.*;
import java.awt.*;

public class PongTester {

    public static void main(String[] args) {
        JFrame panel = new JFrame();
        ColorPanel view = new ColorPanel(Color.WHITE, 1200, 800);
        panel.setSize(new Dimension(1200, 800));
        panel.add(view);
        panel.setVisible(true);
        view.setVisible(true);
    }
}
