package com.company;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomEmployee extends Employee{

    private String lastName;
    private String firstName;
    private int hoursWorked;
    private String rate;
    private double rateDouble;
    private int idNum;
    private int age;
    private String nickName;
    static private int idNumIncrement = 0;
    private String sex;
    private int numDependents;

    //Must randomly generate
    // first name,
    // last name,
    // hoursworked, DONE
    // hourlypay, DONE
    // idnum, DONE
    // numofdependents, DONE
    // sex

    public RandomEmployee(){
        super();
        sex = "male";
        numDependents = 0;
    }
    //Create constructor that passes in values, generate them randomly on the tester field
    public RandomEmployee(String fn, String ln, int hoursWorked, double rd, int age, int nd, String sx){
        super(ln, fn, hoursWorked, rd, age, fn);
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
        return "RandomEmployee{" +
                "lastName='" + getLastName() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", hoursWorked=" + getHoursWorked() +
                ", rateDouble='" + getRateDouble() + '\'' +
                ", idNum=" + getIdNum() +
                ", age=" + getAge() +
                ", sex=" + getSex() +
                ", nickName='" + getNickName() + '\'' +
                ", numDependents='" + getNumDependents() + '\'' +
                ", grossPay='" + getGrossPay() + '\'' +
                ", overTime='" + checkOvertime() + '\'' +
                '}';
    }

}
