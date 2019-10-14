package com.company;

import java.io.*;
import java.text.DecimalFormat;
import java.util.Random;

public class PayrollEmployee extends Employee{

    private String sex;
    private int numDependents;
    private int weeksWorked;

    //Random employee creator
    public PayrollEmployee(){
        super();
        String randomLastName = "Smith";
        String randomFirstName = "John";
        int randomNumDependents;
        int randomHoursWorked;
        int randomWeeksWorked;
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
            //Weeks worked
            randomWeeksWorked = (int)((Math.random()*52));
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
            setFirstName(randomFirstName);
            setLastName(randomLastName);
            setHoursWorked(randomHoursWorked);
            setRateDouble(randomDoubleRate);
            setAge(randomAge);
            setNumDependents(randomNumDependents);
            setSex(randomSex);
            setWeeksWorked(randomWeeksWorked);
    }

    //Create constructor that passes in values, generate them randomly on the tester field
    public PayrollEmployee(String fn, String ln, int hoursWorked, double rd, int age, int nd, String sx, int weeksWorkedPass){
        super(ln, fn, hoursWorked, rd, age, fn);
        numDependents = nd;
        sex = sx;
        weeksWorked = weeksWorkedPass;
    }
    public PayrollEmployee(String fn, String ln, int idNumPass, int hoursWorked, double rd, int age, int nd, String sx, int weeksWorkedPass){
        super(ln, fn, idNumPass, hoursWorked, rd, age, fn);
        numDependents = nd;
        sex = sx;
        weeksWorked = weeksWorkedPass;
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

    public int getWeeksWorked() {
        return weeksWorked;
    }

    public void setWeeksWorked(int weeksWorked) {
        this.weeksWorked = weeksWorked;
    }

    //Custom methods
    public double getGrossPay(){
        if (getRate() != null){
            String[] rat = getRate().split("/");
            return (Double.parseDouble(rat[0]) / Double.parseDouble(rat[1]))*getHoursWorked();
        }else{
            return (getRateDouble() * getHoursWorked());
        }
    }
    public boolean checkOvertime(){
        return getHoursWorked() > 40;
    }

    public double getSS(){
        return getGrossPay() * (.062/12);
    }
    public double getFed(){
        return getGrossPay() * (.2 * (Math.pow(.95, numDependents)));

    }
    public double getState(){
        return getGrossPay() * (.1*(Math.pow(.95, numDependents)));

    }
    public double getLocal(){
        return getGrossPay() * (.05 * (Math.pow(.95, numDependents)));
    }

    public double getNetPay(){
        return getGrossPay() - getSS() - getFed() - getState() - getLocal();
    }

    public String toPayStub(){
        DecimalFormat df = new DecimalFormat("0.00");
        return getFirstName() + " " + getLastName() +System.lineSeparator() +
                "ID Number: " + getIdNum() + System.lineSeparator() +
                "Pay Rate: $" + df.format(getRateDouble()) +"/hr"+ System.lineSeparator()+
                "Hours Worked: " + df.format(getHoursWorked()) + System.lineSeparator() +
                "Overtime: " + checkOvertime() + System.lineSeparator() +
                "Gross Pay: $" + df.format(getGrossPay()) + System.lineSeparator() +
                "Net Pay: $" + df.format(getNetPay()) + System.lineSeparator()+
                "Fed Tax: $" + df.format(getFed()) + System.lineSeparator() +
                "State Tax: $" + df.format(getState()) + System.lineSeparator() +
                "Local Tax: $" + df.format(getLocal()) + System.lineSeparator()+
                "Social Security Tax: $" + df.format(getSS());
    }
    public String toYTDString(){
        DecimalFormat df = new DecimalFormat("0.00");
        return getFirstName() + " " + getLastName() +System.lineSeparator() +
                "ID Number: " + getIdNum() + System.lineSeparator() +
                "Pay Rate: $" + df.format(getRateDouble()) +"/hr"+ System.lineSeparator()+
                "Hours Worked: " + df.format(getHoursWorked()*getWeeksWorked()) + System.lineSeparator() +
                "Weeks Worked: " + df.format(getWeeksWorked()) + System.lineSeparator() +
                "Overtime: " + checkOvertime() + System.lineSeparator() +
                "Gross Pay: $" + df.format(getGrossPay()*getWeeksWorked()) + System.lineSeparator() +
                "Net Pay: $" + df.format(getNetPay()*getWeeksWorked()) + System.lineSeparator()+
                "Fed Tax: $" + df.format(getFed()*getWeeksWorked()) + System.lineSeparator() +
                "State Tax: $" + df.format(getState()*getWeeksWorked()) + System.lineSeparator() +
                "Local Tax: $" + df.format(getLocal()*getWeeksWorked()) + System.lineSeparator()+
                "Social Security Tax: $" + df.format(getSS()*getWeeksWorked());
    }

    //toString override method
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
                ", " + checkOvertime() +
                ", " + getWeeksWorked();
    }

}
