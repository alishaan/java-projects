package com.company;

public class Teacher {
    private String degree;
    private int years;
    private double actualSalary;
    private double baseSalary;

    public Teacher(){
        degree = "bachelor's";
        years = 1;
        baseSalary = 40000;
        actualSalary = getSalary();
    }
    public Teacher(String degreePass, int yearsPass, double baseSalaryPass){
        degree = degreePass;
        years = yearsPass;
        baseSalary = baseSalaryPass;
        actualSalary = getSalary();
    }
    public double getSalary(){
        if (degree.equals("bachelor's")){
            return (double)(baseSalary*Math.pow(1.02, years-1));
        }else if(degree.equals("master's")){
            return (double)(baseSalary*Math.pow(1.02, years-1)*1.2);
        }else{
            return (double)(baseSalary*Math.pow(1.02, years-1)*1.4);
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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "degree='" + degree + '\'' +
                ", years=" + years +
                ", salary=" + actualSalary +
                '}';
    }
}
