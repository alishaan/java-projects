package com.company;

import java.io.*;
import java.util.Random;

public class PayrollEmployee extends Employee{

    private String sex;
    private int numDependents;

    //Random employee creator
    public PayrollEmployee(){
        super();
        String randomLastName = "Smith";
        String randomFirstName = "John";
        int randomNumDependents;
        int randomHoursWorked;
        double randomDoubleRate;
        int randomAge;
        String randomSex;
        int employeeCount = 0;
        int numEmployees = 100;

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
            setFirstName(randomFirstName);
            setLastName(randomLastName);
            setHoursWorked(randomHoursWorked);
            setRateDouble(randomDoubleRate);
            setAge(randomAge);
            setNumDependents(randomNumDependents);
            setSex(randomSex);
    }

    //Create constructor that passes in values, generate them randomly on the tester field
    public PayrollEmployee(String fn, String ln, int hoursWorked, double rd, int age, int nd, String sx){
        super(ln, fn, hoursWorked, rd, age, fn);
        numDependents = nd;
        sex = sx;
    }
    public PayrollEmployee(String fn, String ln, int idNumPass, int hoursWorked, double rd, int age, int nd, String sx){
        super(ln, fn, idNumPass, hoursWorked, rd, age, fn);
        numDependents = nd;
        sex = sx;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getNumDependents() {
        return numDependents;
    }

    public void setNumDependents(int numDependents) {
        this.numDependents = numDependents;
    }

    public String toString(){
        return
                getLastName() +
                ", "+ getFirstName() +
                ", " + getIdNum() +
                ", "+ getHoursWorked() +
                ", " + getRateDouble() +
                ", " + getAge() +
                ", " + getSex() +
                ", " + getNickName() +
                ", " + getNumDependents() +
                ", " + getGrossPay() +
                ", " + checkOvertime();
    }

}
