package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MatrixTester {

    public static void main(String[] args) {
        String rows = JOptionPane.showInputDialog("Enter the amount of rows");
        String columns = JOptionPane.showInputDialog("Enter the amount of columns");

        Matrix testMatrix = new Matrix(Integer.parseInt(rows),Integer.parseInt(columns));

        JFrame gui = new JFrame();
        DefaultTableModel tableModel = new DefaultTableModel(testMatrix.generateObjectArray(), testMatrix.generateColumnNames());
        JTable matrix1 = new JTable(tableModel);

        gui.add(new JScrollPane(matrix1));
        gui.setSize(1000, 1000);
        gui.setVisible(true);


    }
}
