package com.company;

public class PartTimeEmployee extends Employee {

    public PartTimeEmployee() {
        super();
    }

    public PartTimeEmployee(String n, double r, int h){
        super(n, r, h);
        totalPay += getPay();
    }

    public double getPay() {
        double pay;
        pay = rate * hours;
        //totalPay += pay;
        return pay;
    }

    public double getDues(){return 0;}
}

