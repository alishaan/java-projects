package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MatrixTester {

    public static void main(String[] args) {
        String rows = JOptionPane.showInputDialog("Enter the amount of rows");
        String columns = JOptionPane.showInputDialog("Enter the amount of columns");

        Matrix matrixObject1 = new Matrix(Integer.parseInt(rows),Integer.parseInt(columns));

        JFrame gui = new JFrame();
        DefaultTableModel tableModel = new DefaultTableModel(matrixObject1.generateObjectArray(), matrixObject1.generateColumnNames());
        JTable matrix1 = new JTable(tableModel);
        JScrollPane matrix1Scroll = new JScrollPane(matrix1);

        gui.add(matrix1Scroll);

        //Checks to see if the table value has been edited and reflects it into the matrix object
        tableModel.addTableModelListener(tableModelEvent -> {
            if (matrix1.isEditing()){
                Object value = matrix1.getValueAt(matrix1.getSelectedRow(), matrix1.getSelectedColumn());
                matrixObject1.getMatrix()[matrix1.getSelectedRow()][matrix1.getSelectedColumn()] = Double.parseDouble((String)value);
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setSize(new Dimension(250, 500));

        JButton add = new JButton("Add");
        JButton subtract = new JButton("Subtract");
        JButton multiply = new JButton("Multiply");
        JButton divide = new JButton("Divide");
        JButton transpose = new JButton("Transpose");

        buttonsPanel.add(add);
        buttonsPanel.add(subtract);
        buttonsPanel.add(multiply);
        buttonsPanel.add(divide);
        buttonsPanel.add(transpose);

        gui.add(buttonsPanel);
        gui.add(matrix1Scroll);

        gui.setSize(1000, 500);
        buttonsPanel.setLocation(400, 200);

        gui.setVisible(true);

        add.addActionListener(actionEvent -> {
            Matrix matrixObject2 = new Matrix(Integer.parseInt(rows),Integer.parseInt(columns));

            JFrame gui2 = new JFrame();
            DefaultTableModel tableModel2 = new DefaultTableModel(matrixObject2.generateObjectArray(), matrixObject2.generateColumnNames());
            JTable matrix2 = new JTable(tableModel2);
            JScrollPane matrix1Scroll13 = new JScrollPane(matrix2);


            tableModel2.addTableModelListener(tableModelEvent -> {
                if (matrix2.isEditing()){
                    Object value = matrix2.getValueAt(matrix2.getSelectedRow(), matrix2.getSelectedColumn());
                    matrixObject2.getMatrix()[matrix2.getSelectedRow()][matrix2.getSelectedColumn()] = Double.parseDouble((String)value);
                }
            });

            JPanel buttonsPanel2 = new JPanel();
            buttonsPanel2.setSize(new Dimension(250, 500));
            JButton add2 = new JButton("Add");
            buttonsPanel2.add(add2);

            add2.addActionListener(actionEvent1 -> {
                Matrix matrixObject3 = matrixObject1.add(matrixObject2);

                JFrame gui3 = new JFrame();
                DefaultTableModel tableModel3 = new DefaultTableModel(matrixObject3.generateObjectArray(), matrixObject3.generateColumnNames());
                JTable matrix3 = new JTable(tableModel3);
                JScrollPane matrix1Scroll1 = new JScrollPane(matrix3);

                gui3.add(matrix1Scroll1);
                gui3.setSize(1000,500);
                gui3.setVisible(true);
            });

            gui2.setSize(1000, 500);
            buttonsPanel2.setLocation(400, 200);
            gui2.add(buttonsPanel2);
            gui2.add(matrix1Scroll13);
            gui2.setVisible(true);
        });

        subtract.addActionListener(actionEvent -> {
            Matrix matrixObject2 = new Matrix(Integer.parseInt(rows),Integer.parseInt(columns));

            JFrame gui2 = new JFrame();
            DefaultTableModel tableModel2 = new DefaultTableModel(matrixObject2.generateObjectArray(), matrixObject2.generateColumnNames());
            JTable matrix2 = new JTable(tableModel2);
            JScrollPane matrix1Scroll12 = new JScrollPane(matrix2);


            tableModel2.addTableModelListener(tableModelEvent -> {
                if (matrix2.isEditing()){
                    Object value = matrix2.getValueAt(matrix2.getSelectedRow(), matrix2.getSelectedColumn());
                    matrixObject2.getMatrix()[matrix2.getSelectedRow()][matrix2.getSelectedColumn()] = Double.parseDouble((String)value);
                }
            });

            JPanel buttonsPanel2 = new JPanel();
            buttonsPanel2.setSize(new Dimension(250, 500));
            JButton subtract2 = new JButton("Subtract");
            buttonsPanel2.add(subtract2);

            subtract2.addActionListener(actionEvent1 -> {
                Matrix matrixObject3 = matrixObject1.subtract(matrixObject2);

                JFrame gui3 = new JFrame();
                DefaultTableModel tableModel3 = new DefaultTableModel(matrixObject3.generateObjectArray(), matrixObject3.generateColumnNames());
                JTable matrix3 = new JTable(tableModel3);
                JScrollPane matrix1Scroll1 = new JScrollPane(matrix3);

                gui3.add(matrix1Scroll1);
                gui3.setSize(1000,500);
                gui3.setVisible(true);
            });

            gui2.setSize(1000, 500);
            buttonsPanel2.setLocation(400, 200);
            gui2.add(buttonsPanel2);
            gui2.add(matrix1Scroll12);
            gui2.setVisible(true);
        });

    }
}
