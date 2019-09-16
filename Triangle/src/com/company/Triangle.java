package com.company;

import javax.sound.sampled.Line;

public class Triangle {
    private double area = getArea();
    private double perimeter = getPerimeter();
    private LineSeg LineSeg1;
    private LineSeg LineSeg2;
    private LineSeg LineSeg3;
    //Fill Constructor
    public Triangle(LineSeg lineSeg1, LineSeg lineSeg2, LineSeg lineSeg3) {
        LineSeg1 = lineSeg1;
        LineSeg2 = lineSeg2;
        LineSeg3 = lineSeg3;
    }
    // Default Constructor
    public Triangle(){
        LineSeg1 = new LineSeg();
        LineSeg2 = new LineSeg();
        LineSeg3 = new LineSeg();
    }
    //Copy Constructor
    public Triangle(Triangle originalTriangle){
        LineSeg1 = originalTriangle.LineSeg1;
        LineSeg2 = originalTriangle.LineSeg2;
        LineSeg3 = originalTriangle.LineSeg3;
    }
    //Gets and Sets
    public LineSeg getLineSeg1() {
        return LineSeg1;
    }

    public void setLineSeg1(LineSeg lineSeg1) {
        LineSeg1 = lineSeg1;
    }

    public LineSeg getLineSeg2() {
        return LineSeg2;
    }

    public void setLineSeg2(LineSeg lineSeg2) {
        LineSeg2 = lineSeg2;
    }

    public LineSeg getLineSeg3() {
        return LineSeg3;
    }

    public void setLineSeg3(LineSeg lineSeg3) {
        LineSeg3 = lineSeg3;
    }
    //Perimeter Method
    public double getPerimeter(){
        return perimeter = LineSeg1.getDistance() + LineSeg2.getDistance() + LineSeg3.getDistance(); //Add the distances of the line segments to get the perimeter
    }
    public double getArea(){
        double s = .5 * getPerimeter();
        return java.lang.Math.sqrt(s*(s-LineSeg1.getDistance())*(s-LineSeg2.getDistance())*(s-LineSeg3.getDistance()));
    }
    public boolean isTriangle(){
        if ((LineSeg1.getDistance() + LineSeg2.getDistance() > LineSeg3.getDistance())||(LineSeg3.getDistance() + LineSeg2.getDistance() > LineSeg1.getDistance())||(LineSeg3.getDistance() + LineSeg1.getDistance() > LineSeg2.getDistance())){ //utilizing inequality theorem
           return true;
        }
        else{
            return false;
        }
    }
}
