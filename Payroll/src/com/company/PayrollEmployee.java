package com.company;

public class PayrollEmployee extends Employee{

    private String sex;
    private int numDependents;

    //Must randomly generate
    // first name, DONE
    // last name, DONE
    // hoursworked, DONE
    // hourlypay, DONE
    // idnum, DONE
    // numofdependents, DONE
    // sex DONE

    public PayrollEmployee(){
        super();
        sex = "male";
        numDependents = 0;
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
