// 3x3 Grid Generator
// Chapter 2.7 activity

//Imports
//For GUI
import javax.swing.*;
//For Color & Container
import java.awt.*;
//For scanner
import java.util.*;

public class Main{
  public static void main(String[] args){
    //variable for the do while loop
    int restart = 0;
    do{
      //Creating required objects
      JFrame GUI = new JFrame();
      Container panel = GUI.getContentPane();

      //GUI Settings
      GUI.setSize(600, 600);
      GUI.setTitle("2.7 Color Grid Activity");

      //User input on grid size
      JOptionPane dimensions = new JOptionPane(JOptionPane.QUESTION_MESSAGE, JOptionPane.QUESTION_MESSAGE);
      dimensions.setVisible(true);
      //integers because we can't have decimal grid numbers
      int h = Integer.parseInt(JOptionPane.showInputDialog("Enter height:", 0));
      int w = Integer.parseInt(JOptionPane.showInputDialog("Enter width:", 0));
      //now set the actual panel to those dimensions
      panel.setLayout(new GridLayout(h,w));
      //Create random colors
      int randomColorOne = (int)(255 * Math.random());
      int randomColorTwo = (int)(255 * Math.random());
      int randomColorThree = (int)(255 * Math.random());
      //creates a 'panel' by looping through the area (h*w)
      if (w%2 == 0){
        for(int hNum = 0; hNum<h; hNum++){
          if (hNum%2 == 0){
            for(int i=0; i<w; i++){
              if(i%2 == 0){
                JPanel pane = new JPanel();
                pane.setBackground(new Color(randomColorOne,randomColorTwo,randomColorThree));
                panel.add(pane);
              }else{
                JPanel pane = new JPanel();
                pane.setBackground(new Color(randomColorThree,randomColorTwo,randomColorOne));
                panel.add(pane);
              }
            }
          }else{
            for(int i=0; i<w; i++){
              if(i%2 == 0){
                JPanel pane = new JPanel();
                pane.setBackground(new Color(randomColorThree,randomColorTwo,randomColorOne));
                panel.add(pane);
              }else{
                JPanel pane = new JPanel();
                pane.setBackground(new Color(randomColorOne,randomColorTwo,randomColorThree));
                panel.add(pane);
              }
            }
          }
        }
      }else{
        for(int i=0; i<(w*h); i++){
          if (i%2 == 0){
            JPanel pane = new JPanel();
            pane.setBackground(new Color(randomColorOne,randomColorTwo,randomColorThree));
            panel.add(pane);
          }else{
            JPanel pane = new JPanel();
            pane.setBackground(new Color(randomColorThree,randomColorTwo,randomColorOne));
            panel.add(pane);
          }
        }
      }
      GUI.setVisible(true);
      restart = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to restart:", 0));
    }while(restart == 1);
  }
}