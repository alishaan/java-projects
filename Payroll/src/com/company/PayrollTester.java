package com.company;

import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class PayrollTester {

    public static void main(String[] args) throws IOException {
        //Open file of employee output
        Payroll payroll = new Payroll(new File("employeeOutput.csv"));
        
        //Control variables
        int restart = 0;
        int error = 0;

        //Create gui
        JPanel gui = new JPanel();
        gui.setVisible(true);

        //Ask which employee to bring up
        do{
            String selector = JOptionPane.showInputDialog(gui, "Enter an employee id number or enter 'exit' or 'summary': ");
            //Conditional Statements
            if(selector.toUpperCase().equals("EXIT")){
                restart = 1;
            }else if(selector.toUpperCase().equals("SUMMARY")){
                JOptionPane.showMessageDialog(gui, payroll.toReadableString());
            }else{
                //Get integer value of the passed id num
                int idNum = Integer.parseInt(selector);
                //run through the array for the idnum employee
                for(int i = 0; i<payroll.getEmployeeArray().size(); i++){
                    if(payroll.getEmployeeArray().get(i).getIdNum() == idNum){
                        PayrollEmployee selectedEmployee = payroll.getEmployeeArray().get(i);
                        error = 0;
                        JOptionPane.showMessageDialog(gui, selectedEmployee.toReadableString());
                        break;
                    }else{
                        error = 1;
                    }
                }
                //Checks if an idNum not in the array was passed
                if(error==1) {
                    JOptionPane.showMessageDialog(gui, "Employee not found!");
                }
            }
        }while(restart == 0);
    }
}