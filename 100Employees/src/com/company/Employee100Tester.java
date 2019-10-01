package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Employee100Tester {

    public static void main(String[] args) throws IOException {
        String randomLastName = "Smith";
        String randomFirstName = "John";
        int randomNumDependents;
        int randomHoursWorked;
        double randomDoubleRate;
        int randomAge;
        String randomSex;
        int employeeCount = 0;
        int numEmployees;

        Scanner employeeInput = new Scanner(System.in);
        System.out.print("Enter the amount of employees you want to generate?: ");
        numEmployees = employeeInput.nextInt();
        String[] randomEmployeeArray = new String[numEmployees];


        //Get the amount of last names
        int linesLast = 0;
        try {
            LineNumberReader lastNamesCount = new LineNumberReader(new FileReader("src/LastNames.txt"));
            while (lastNamesCount.readLine() != null) {
                linesLast++;
            }
            lastNamesCount.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        //Get the amount of Male First Names
        int linesMaleNames = 0;
        try {
            LineNumberReader maleNamesCount = new LineNumberReader(new FileReader("src/MaleNamesDictionary.txt"));
            while (maleNamesCount.readLine() != null) {
                linesMaleNames++;
            }
            maleNamesCount.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        //Get the amount of Female First Names
        int linesFemaleNames = 0;
        try {
            LineNumberReader femaleNamesCount = new LineNumberReader(new FileReader("src/MaleNamesDictionary.txt"));
            while (femaleNamesCount.readLine() != null) {
                linesFemaleNames++;
            }
            femaleNamesCount.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        //Get the amount of Female Last Names
        //Get the amount of Male Last Names
        do{
            employeeCount++;
            //Generate random values between certain
            //Dependents
            randomNumDependents = (int)(Math.random()*6);
            //Hours Worked
            randomHoursWorked = (int)(Math.random()*60)+20;
            //Pay rate
            randomDoubleRate = (Math.random()*25)+10;
            //Age
            randomAge = (int)((Math.random()*47)+18);
            //Sex
            Random random = new Random();
            if (random.nextBoolean()) {
                randomSex = "male";
            } else {
                randomSex = "female";
            }
            //Last Name
            try {
                LineNumberReader lastNamesReader = new LineNumberReader(new FileReader("src/LastNames.txt"));
                int randomLastNameInt = (int)(linesLast * Math.random());
                for(int i=0; i<randomLastNameInt; i++) {
                    randomLastName = lastNamesReader.readLine();
                }
                lastNamesReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //First Name by Sex
            if (randomSex.equals("male")){
                try {
                    LineNumberReader maleNamesReader = new LineNumberReader(new FileReader("src/MaleNamesDictionary.txt"));
                    int randomMaleFirstNameInt = (int)(linesMaleNames * Math.random());
                    for(int i=0; i<randomMaleFirstNameInt; i++) {
                        randomFirstName = maleNamesReader.readLine();
                    }
                    maleNamesReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                try {
                    LineNumberReader maleNamesReader = new LineNumberReader(new FileReader("src/FemaleNamesDictionary.txt"));
                    int randomFemaleFirstNameInt = (int)(linesFemaleNames * Math.random());
                    for(int i=0; i<randomFemaleFirstNameInt; i++) {
                        randomFirstName = maleNamesReader.readLine();
                    }
                    maleNamesReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            RandomEmployee randomEmployee = new RandomEmployee(randomFirstName, randomLastName, randomHoursWorked, randomDoubleRate, randomAge, randomNumDependents, randomSex);
            randomEmployeeArray[employeeCount-1] = randomEmployee.toString();

        }while(employeeCount < numEmployees);
        //Make a large string
        String randomEmployeeArrayString = "";
        for (int i=0; i < randomEmployeeArray.length; i++){
            randomEmployeeArrayString = randomEmployeeArrayString +randomEmployeeArray[i] + System.lineSeparator();
        }
        FileWriter write = new FileWriter("employeeOutput.csv");
        PrintWriter print_line = new PrintWriter(write);
        print_line.println("LAST_NAME, FIRST_NAME, ID_NUMBER, HOURS_WORKED, RATE, AGE, SEX, NICK_NAME, DEPENDENTS, GROSS_PAY, OVERTIME");
        print_line.print(randomEmployeeArrayString);
        print_line.close();
    }
}
