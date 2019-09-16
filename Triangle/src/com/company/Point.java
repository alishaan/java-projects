package com.company;

public class Point {
    //Variables
    private int x;
    private int y;
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
}
