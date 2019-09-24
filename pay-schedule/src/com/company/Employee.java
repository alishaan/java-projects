package com.company;

public class Employee {
    private String degree;
    private int years;
    private int salary;

    public Employee(){
        degree = "bachelor's";
        years = 1;
        salary = getSalary();
    }
    public Employee(String degreePass, int yearsPass){
        degree = degreePass;
        years = yearsPass;
        salary = getSalary();
    }
    public int getSalary(){
        if (degree.equals("bachelors")){
            return (int)(40000*Math.pow(1.02, years-1));
        }else if(degree.equals("masters")){
            return (int)(50000*Math.pow(1.02, years-1));
        }else{
            return (int)(60000*Math.pow(1.02, years-1));
        }
    }
    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "degree='" + degree + '\'' +
                ", years=" + years +
                ", salary=" + salary +
                '}';
    }
}
