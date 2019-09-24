package com.company;
import javax.swing.*;

public class PayScheduleTester {
    public static void main(String[] args) {
        //Check if user wants to use file or type information
        int fileOrInput = JOptionPane.showConfirmDialog(null, "Would you like to read from a file?");
        if (fileOrInput == JOptionPane.YES_OPTION){
            //read file
        }else{
            //Input for all the values
            String degreeLevel = JOptionPane.showInputDialog(null, "What degree is the teacher?");
            String baseSalaryString = JOptionPane.showInputDialog(null, "What is the district's base salary for teachers?");
            int baseSalary = Integer.parseInt(baseSalaryString);
            String yearsWorkedString = JOptionPane.showInputDialog(null, "How many years has the teacher worked at the school?");
            int yearsWorked = Integer.parseInt(yearsWorkedString);
            //Create teacher object
            Teacher newTeacher = new Teacher(degreeLevel, yearsWorked, baseSalary);
            //Create pay schedule object
            SalarySchedule salarySchedule = new SalarySchedule(newTeacher);
            //Print out the salary schedule
            System.out.println(salarySchedule.generateSchedule());

            JOptionPane.showMessageDialog(null, "The teacher's salary is " + newTeacher.getSalary());
        }
    }
}
