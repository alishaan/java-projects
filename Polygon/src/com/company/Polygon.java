package com.company;

import java.awt.geom.Line2D;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Polygon {
    //Array list to store points
    private ArrayList<Point> polygonPoints = new ArrayList<Point>();

    public Polygon(){
        polygonPoints.add(new Point());
    }
    public Polygon(ArrayList<Point> points){
        polygonPoints = points;
    }

    public Polygon(ArrayList<LineSeg> lineSegs, String lineSegDeclaration){
        for(int i = 0; i < lineSegs.size(); i++){
            polygonPoints.add(lineSegs.get(i).getMyBP());
        }
    }

    double getArea(){
        // Initialize area
        double area = 0.0;

        // Calculate value of shoelace formula
        int j = polygonPoints.size() - 1;
        for (int i = 0; i < polygonPoints.size(); i++)
        {
            area += (polygonPoints.get(j).getX() + polygonPoints.get(i).getX()) * (polygonPoints.get(j).getY() - polygonPoints.get(i).getY());
            j = i;  // j is previous vertex to i
        }

        // Return absolute value
        return Math.abs(area / 2.0);
    }

    public ArrayList<Point> getPolygonPoints() {
        return polygonPoints;
    }

    public void setPolygonPoints(ArrayList<Point> polygonPoints) {
        this.polygonPoints = polygonPoints;
    }

    public ArrayList<LineSeg> getLineSegs(){
        ArrayList<LineSeg> lineSegArrayList = new ArrayList<LineSeg>();
        if(polygonPoints.size() == 1){
            return lineSegArrayList;
        }else if (polygonPoints.size() == 2){
            lineSegArrayList.add(new LineSeg(polygonPoints.get(0), polygonPoints.get(1)));
            return lineSegArrayList;
        }else{
            for(int i = 0; i<polygonPoints.size()-1; i++){
                lineSegArrayList.add(new LineSeg(polygonPoints.get(i), polygonPoints.get(i+1)));
            }
            lineSegArrayList.add(new LineSeg(polygonPoints.get(polygonPoints.size()-1), polygonPoints.get(0)));
            return lineSegArrayList;
        }
    }

    public double getPerimeter(){
        ArrayList<LineSeg> lineSegArrayList = getLineSegs();
        double perimeter = 0;
        for(int i = 0; i < lineSegArrayList.size(); i++){
            perimeter += lineSegArrayList.get(i).getDistance();
        }
        return perimeter;
    }

    public boolean checkPolygon(){
        if(getLineSegs().size() <= 2){
            return false;
        }else if(getLineSegs().size() == 3){
            return true;
        }
        for(int i = 0; i < getLineSegs().size(); i++){
            for(int j = 0; j < getLineSegs().size(); j++){
                Line2D line1 = new Line2D.Float(getLineSegs().get(i).getMyBP().getX(), getLineSegs().get(i).getMyBP().getY(), getLineSegs().get(i).getMyEP().getX(), getLineSegs().get(i).getMyEP().getY());
                Line2D line2 = new Line2D.Float(getLineSegs().get(j).getMyBP().getX(), getLineSegs().get(j).getMyBP().getY(), getLineSegs().get(j).getMyEP().getX(), getLineSegs().get(j).getMyEP().getY());
                if(line2.intersectsLine(line1) && (line1.getX2() != line2.getX1()&&line1.getX1() != line2.getX2()&&line1.getX1() != line2.getX1()&&line1.getX2()!= line2.getX2())){
                    return false;
                }
            }
        }
        return true;
    }
    

    @Override
    public String toString() {
        String returnString = "";
        for(var i = 0; i < getPolygonPoints().size(); i++){
            returnString += "Point " + (i+1) + ": " + getPolygonPoints().get(i).toStringCommon() + System.lineSeparator();
        }
        for(var i = 0; i < getLineSegs().size(); i++){
            returnString += "LineSeg " + (i+1) + ": " + getLineSegs().get(i).toStringCommon() + System.lineSeparator();
        }
        returnString += "Area: " + getArea() + System.lineSeparator();
        returnString += "Perimeter: " + getPerimeter() + System.lineSeparator();
        returnString += "Is Polygon?: " + checkPolygon();
        return returnString;
    }
}
