package com.company;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SalaryScheduleTester {
    public static void main(String[] args) throws FileNotFoundException {
        //Check if user wants to use file or type information
        int fileOrInput = JOptionPane.showConfirmDialog(null, "Would you like to read from a file?");
        if (fileOrInput == JOptionPane.YES_OPTION){
            //need to read file
            File teacherTextFile = new File("src/teacher.txt");
            String absolutePath = teacherTextFile.getAbsolutePath();
            try (Scanner fileReader = new Scanner(new File(absolutePath))) {
                String degreeLevel = fileReader.nextLine();
                String yearsWorkedString = fileReader.nextLine();
                int yearsWorked = Integer.parseInt(yearsWorkedString);
                String baseSalaryString = fileReader.nextLine();
                int baseSalary = Integer.parseInt(baseSalaryString);
                Teacher newTeacher = new Teacher(degreeLevel, yearsWorked, baseSalary);
                //Create pay schedule object
                SalarySchedule salarySchedule = new SalarySchedule(newTeacher);
                //Print out the salary schedule
                System.out.println(salarySchedule.generateSchedule());
                //Output teacher salary
                JOptionPane.showMessageDialog(null, "The teacher's salary is " + newTeacher.getSalary());
            }
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
            //Output teacher salary
            JOptionPane.showMessageDialog(null, "The teacher's salary is " + newTeacher.getSalary());
        }
    }
}
