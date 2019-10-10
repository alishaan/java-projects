package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Payroll {
    private ArrayList<PayrollEmployee> employeeArray = new ArrayList<PayrollEmployee>();

    //Default constructor generates an array of 100 employees and the corresponding output file
    public Payroll() throws IOException {
        String randomLastName = "Smith";
        String randomFirstName = "John";
        int randomNumDependents;
        int randomHoursWorked;
        double randomDoubleRate;
        int randomAge;
        String randomSex;
        int employeeCount = 0;
        int numEmployees = 100;

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
            PayrollEmployee randomEmployee = new PayrollEmployee(randomFirstName, randomLastName, randomHoursWorked, randomDoubleRate, randomAge, randomNumDependents, randomSex);
            randomEmployeeArray[employeeCount-1] = randomEmployee.toString();
            employeeArray.add(randomEmployee);

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

    //Fill Constructor will take in a file and generate an array of employees from it
    public Payroll(File passedFile) throws IOException {
        int passedFileLengthInt = 0;
        try {
            LineNumberReader passedFileLength = new LineNumberReader(new FileReader(passedFile));
            while (passedFileLength.readLine() != null) {
                passedFileLengthInt++;
            }
            passedFileLength.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        //remove one for the header
        passedFileLengthInt -= 1;

        //open up the passed file and loop through the header
        LineNumberReader passedFileReader = new LineNumberReader(new FileReader(passedFile));
        passedFileReader.readLine();

        //loop through the employees in the csv file
        for(int i=0; i<passedFileLengthInt; i++){
            //read the line and store it to main string
            String readString = passedFileReader.readLine();
            //split into array by finding of ", "
            String[] attributes = readString.split(", ");
            //take array and pass it into new PayrollEmployee
            String firstName = attributes[1];
            String lastName = attributes[0];
            int idNum = Integer.parseInt(attributes[2]);
            int hoursWorked = Integer.parseInt(attributes[3]);
            double rateDouble = Double.parseDouble(attributes[4]);
            int age = Integer.parseInt(attributes[5]);
            int numDependents = Integer.parseInt(attributes[8]);
            String sex = attributes[6];

            //create new payroll employee
            PayrollEmployee payrollEmployee = new PayrollEmployee(firstName, lastName, idNum, hoursWorked, rateDouble, age, numDependents, sex);

            //add employee to the array
            employeeArray.add(payrollEmployee);

        }
    }

    public ArrayList<PayrollEmployee> getEmployeeArray() {
        return employeeArray;
    }

    public void setEmployeeArray(ArrayList<PayrollEmployee> employeeArray) {
        this.employeeArray = employeeArray;
    }
}

