package com.company;
import javax.swing.*;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryScheduleTester {
    public static void main(String[] args) throws IOException {
        DecimalFormat f = new DecimalFormat("##.00");
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
                double baseSalary = Integer.parseInt(baseSalaryString);
                Teacher newTeacher = new Teacher(degreeLevel, yearsWorked, baseSalary);
                //Create pay schedule object
                SalarySchedule salarySchedule = new SalarySchedule(newTeacher);
                //Print out the salary schedule
                System.out.println(salarySchedule.generateSchedule());
                FileWriter write = new FileWriter("teacherOutput.txt");
                PrintWriter print_line = new PrintWriter(write);
                print_line.printf("%s" + "%n", newTeacher.toString());
                print_line.printf("%s" + "%n", salarySchedule.generateSchedule());
                print_line.close();
                //Output teacher salary
                JOptionPane.showMessageDialog(null, "The teacher's salary is " + f.format(newTeacher.getSalary()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            //Input for all the values
            String degreeLevel = JOptionPane.showInputDialog(null, "What degree is the teacher?");
            String baseSalaryString = JOptionPane.showInputDialog(null, "What is the district's base salary for teachers?");
            double baseSalary = Integer.parseInt(baseSalaryString);
            String yearsWorkedString = JOptionPane.showInputDialog(null, "How many years has the teacher worked at the school?");
            int yearsWorked = Integer.parseInt(yearsWorkedString);
            //Create teacher object
            Teacher newTeacher = new Teacher(degreeLevel, yearsWorked, baseSalary);
            //Create pay schedule object
            SalarySchedule salarySchedule = new SalarySchedule(newTeacher);
            //Print out the salary schedule
            System.out.println(salarySchedule.generateSchedule());
            FileWriter write = new FileWriter("teacherOutput.txt");
            PrintWriter print_line = new PrintWriter(write);
            print_line.printf("%s" + "%n", newTeacher.toString());
            print_line.printf("%s" + "%n", salarySchedule.generateSchedule());
            print_line.close();
            //Output teacher salary
            JOptionPane.showMessageDialog(null, "The teacher's salary is " + f.format(newTeacher.getSalary()));
        }
    }
}
