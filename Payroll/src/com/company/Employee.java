package com.company;

public class Employee {
    //Variables
    private String lastName;
    private String firstName;
    private int hoursWorked;
    private String rate;
    private double rateDouble;
    private int idNum;
    private int age;
    private String nickName;
    static private int idNumIncrement = 0;

    //Default constructor
    public Employee() {
        idNumIncrement++;
        lastName = "John";
        firstName = "Doe";
        hoursWorked = 8;
        rateDouble = 10.0;
        age = 18;
        nickName = "John";
        idNum = idNumIncrement;
    }

    public Employee(String last, String first, int hours, double ratePassD, int a, String nick) {
        idNumIncrement++;
        lastName = last;
        firstName = first;
        hoursWorked = hours;
        rateDouble = ratePassD;
        age = a;
        nickName = nick;
        idNum = idNumIncrement;
    }

    public Employee(String last, String first, int hours, String ratePass, int a, String nick) {
        idNumIncrement++;
        lastName = last;
        firstName = first;
        hoursWorked = hours;
        rate = ratePass;
        age = a;
        nickName = nick;
        idNum = idNumIncrement;
    }

    public Employee(String last, String first, int idNumPass, int hours, String ratePass, int a, String nick) {
        idNumIncrement++;
        lastName = last;
        firstName = first;
        hoursWorked = hours;
        rate = ratePass;
        age = a;
        nickName = nick;
        idNum = idNumPass;
    }

    public Employee(String last, String first, int idNumPass, int hours, double ratePass, int a, String nick) {
        idNumIncrement++;
        lastName = last;
        firstName = first;
        hoursWorked = hours;
        rateDouble = ratePass;
        age = a;
        nickName = nick;
        idNum = idNumPass;
    }
    //Set and Get Functions

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public double getRateDouble() {
        return rateDouble;
    }

    public void setRateDouble(double rateDouble) {
        this.rateDouble = rateDouble;
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        if (rate != null) {
            return "Employee{" +
                    "lastName='" + getLastName() + '\'' +
                    ", firstName='" + getFirstName() + '\'' +
                    ", hoursWorked=" + getHoursWorked() +
                    ", rate=" + getRate() +
                    ", idNum=" + getIdNum() +
                    ", age=" + getAge() +
                    ", nickName='" + getNickName() + '\'' +
                    '}';
        } else {
            return "Employee{" +
                    "lastName='" + getLastName() + '\'' +
                    ", firstName='" + getFirstName() + '\'' +
                    ", hoursWorked=" + getHoursWorked() +
                    ", rateDouble='" + getRateDouble() + '\'' +
                    ", idNum=" + getIdNum() +
                    ", age=" + getAge() +
                    ", nickName='" + getNickName() + '\'' +
                    '}';
        }
    }
}