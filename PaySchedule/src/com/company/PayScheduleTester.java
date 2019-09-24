package com.company;
import javax.swing.*;

public class PayScheduleTester {
    public static void main(String[] args) {
        //Check if user wants to use file or type information
        JOptionPane fileOrInput = new JOptionPane("Would you like to read from a file?", JOptionPane.QUESTION_MESSAGE , JOptionPane.YES_NO_OPTION);
        fileOrInput.setVisible(true);
    }
}
