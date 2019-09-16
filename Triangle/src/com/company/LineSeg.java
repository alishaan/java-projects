package com.company;

public class LineSeg {
    private double distance = getDistance();
    private double slope = getSlope();
    private Point myBP;
    private Point myEP;

    //Default constructor
    public LineSeg(){
        myBP = new Point();
        myEP = new Point();
    }
    //Fill constructor
    public LineSeg(Point pointOne, Point pointTwo){
        myBP = pointOne;
        myEP = pointTwo;
    }
    //Copy constructor
    public LineSeg(LineSeg originalSeg){
        myBP = originalSeg.myBP;
        myEP = originalSeg.myEP;
    }
    public double getSlope(){
       return slope = ((myEP.getY()-myBP.getY())/(myEP.getX()-myBP.getX())); //return slope in double format
    }
    public double getDistance(){
       return distance = java.lang.Math.sqrt((((myEP.getY()-myBP.getY())^2) + ((myEP.getX()-myBP.getX())^2))); //return distance in double format
    }

}
