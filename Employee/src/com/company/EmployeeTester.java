package com.company;
//for gui
import javax.swing.*;
//for container
import java.awt.*;
public class EmployeeTester {
    public static void main(String[] args){
        //Create GUI
        JFrame GUI = new JFrame();
        Container pane = GUI.getContentPane();

        //GUI Settings
        GUI.setSize(600, 600);
        GUI.setTitle("Employee Project - Alishaan Ali");

        //Fill Employee
        Employee fillEmployee = new Employee();

        //User Input on EmployeeRateDouble names
        JOptionPane employeeRateDoubleOPane = new JOptionPane(JOptionPane.QUESTION_MESSAGE, JOptionPane.QUESTION_MESSAGE);
        employeeRateDoubleOPane.setVisible(true);
        String firstName = JOptionPane.showInputDialog("Enter first name:", "John");
        String lastName = JOptionPane.showInputDialog("Enter last name:","Doe");
        String nickName = JOptionPane.showInputDialog("Enter nick name:", "John");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:", 18));
        int hoursWorked = Integer.parseInt(JOptionPane.showInputDialog("Enter hours worked:", 40));
        double rate = Double.parseDouble(JOptionPane.showInputDialog("Enter rate paid:", 10.0));

        //Create Double Employee
        Employee employeeRateDouble = new Employee(lastName, firstName, hoursWorked, rate, age, nickName);


        //User Input on EmployeeRateString
        JOptionPane employeeRateStringOPane = new JOptionPane(JOptionPane.QUESTION_MESSAGE, JOptionPane.QUESTION_MESSAGE);
        employeeRateStringOPane.setVisible(true);
        String firstNameString = JOptionPane.showInputDialog("Enter first name:", "John");
        String lastNameString = JOptionPane.showInputDialog("Enter last name:","Doe");
        String nickNameString = JOptionPane.showInputDialog("Enter nick name:", "John");
        int ageString = Integer.parseInt(JOptionPane.showInputDialog("Enter age:", 18));
        int hoursWorkedString = Integer.parseInt(JOptionPane.showInputDialog("Enter hours worked:", 40));
        String rateString = JOptionPane.showInputDialog("Enter rate paid ($/hr):", "10/1");

        //Create String Employee
        Employee employeeRateString = new Employee(lastNameString, firstNameString, hoursWorkedString, rateString, ageString, nickNameString);

        //Create Grid Props
        pane.setLayout(new GridLayout(1,3));
        pane.setBackground(Color.green);

        //Create labels for employees
        JTextArea lblFill = new JTextArea(fillEmployee.toString());
        JTextArea lblEmployeeRateDouble = new JTextArea(employeeRateDouble.toString());
        JTextArea lblEmployeeRateString = new JTextArea(employeeRateString.toString());

        System.out.println(fillEmployee.toString());
        System.out.println(employeeRateDouble.toString());
        System.out.println(employeeRateString.toString());

        //Add text area properties
        lblFill.setWrapStyleWord(true);
        lblFill.setLineWrap(true);
        lblFill.setEditable(false);
        lblEmployeeRateDouble.setWrapStyleWord(true);
        lblEmployeeRateDouble.setLineWrap(true);
        lblEmployeeRateDouble.setEditable(false);
        lblEmployeeRateString.setWrapStyleWord(true);
        lblEmployeeRateString.setLineWrap(true);
        lblEmployeeRateString.setEditable(false);

        //Create the three panels
        JPanel fillPanel = new JPanel();
        JPanel doublePanel = new JPanel();
        JPanel stringPanel = new JPanel();

        //Add respective labels
        fillPanel.add(lblFill);
        doublePanel.add(lblEmployeeRateDouble);
        stringPanel.add(lblEmployeeRateString);

        //add panels and make visible
        GUI.add(fillPanel);
        GUI.add(doublePanel);
        GUI.add(stringPanel);
        GUI.setVisible(true);
    }
}