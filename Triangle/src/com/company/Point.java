package com.company;

public class Point {
    //Variables
    private int x;
    private int y;
    private String toStringCommon;
    //Default constructor
    public Point(){
        x = 0;
        y = 0;
    }
    //Fill constructor
    public Point(int myx,  int myy){
        x = myx;
        y = myy;
    }
    //Copy constructor
    public Point(Point originalPoint){
        x = originalPoint.x;
        y = originalPoint.y;
    }
    //Sets and Gets
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    //Get adjusted coordinates for the current plane
    public int getAdjustedX(){
        return (((TriangleTester.getWidth() / 2) - x) * -1);
    }
    public int getAdjustedY(){
        return ((TriangleTester.getHeight() / 2) - y);
    }
    public void setY(int y) {
        this.y = y;
    }
    //toString method
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
    public String toStringCommon(){
        return "(" + (((TriangleTester.getWidth() / 2) - x) * -1) + ", " + ((TriangleTester.getHeight() / 2) - y) + ")";
    }
}
