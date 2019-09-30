package com.company;

import java.util.Random;

public class Employee100Tester {

    public static void main(String[] args) {
        String randomLastName;
        String randomFirstName;
        int randomNumDependents;
        int randomHoursWorked;
        double randomDoubleRate;
        int randomAge;
        String randomSex;
        String[] randomEmployeeArray = new String[100];
        int employeeCount = 0;

        do{
            employeeCount++;
            //Generate random values between certain
            //Dependents
            randomNumDependents = (int)(Math.random()*6);
            //Hours Worked
            randomHoursWorked = (int)(Math.random()*80);
            //Pay rate
            randomDoubleRate = (Math.random()*25)+1;
            //Age
            randomAge = (int)((Math.random()*47)+18);
            //Sex
            Random random = new Random();
            if (random.nextBoolean()) {
                randomSex = "male";
            } else {
                randomSex = "female";
            }
            randomFirstName = "alishaan";
            randomLastName = "ali";
            RandomEmployee randomEmployee = new RandomEmployee(randomFirstName, randomLastName, randomHoursWorked, randomDoubleRate, randomAge, randomNumDependents, randomSex);
            randomEmployeeArray[employeeCount-1] = randomEmployee.toString();

        }while(employeeCount < 100);
        for (int i=0; i < randomEmployeeArray.length; i++){
            System.out.println(randomEmployeeArray[i]);
        }
    }
}
