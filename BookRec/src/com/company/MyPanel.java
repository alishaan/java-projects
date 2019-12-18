package com.company;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel{

    private Books myb;
    private Readers myr;
    private Reader CurrentReader;

    public MyPanel(Books b, Readers r){
        myb = b;
        myr = r;
        CurrentReader = myr.getReaders()[0];
    }

    public void draw(Reader si){
        CurrentReader = si;
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Book pop = myr.popular(CurrentReader, myb);
        Book methB = myr.methodB(CurrentReader, myb);
        Book methC = myr.methodC(CurrentReader, myb);
        Book rec = myr.matchReader(CurrentReader, myb);
        g.setFont(new Font("Times Roman", Font.PLAIN, 50));
        g.drawString("Popular", 110 , 50);
        g.drawString("Method B", 350, 50);
        g.drawString("Method C", 600, 50);
        g.drawString("Custom", 1000, 50);
        pop.draw(g, 100, 100);
        methB.draw(g, 350, 100);
        methC.draw(g, 600, 100);
        rec.draw(g, 1000, 100);
    }

}
