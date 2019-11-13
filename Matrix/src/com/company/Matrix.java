package com.company;

public class Matrix {
    private int rows;
    private int columns;
    private double[][] matrix;

    //creates matrix of 0's with a dimension
    public Matrix (int r, int c){
        rows = r;
        columns = c;
        matrix = new double[r][c];
    }

    //fill in by passing in a two dimensional array of values
    public Matrix(double[][] data){
        rows = data.length;
        columns = data[0].length;
        matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = data[i][j];
    }

    //check if it can add or subtract
    public boolean canAdd(Matrix toAdd){
        if (toAdd.rows != this.rows || toAdd.columns != this.columns){
            return false;
        }else{
            return true;
        }
    }

    //Function to add matrices
    public Matrix add(Matrix toAdd){
        if (canAdd(toAdd)){
            Matrix C = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++)
                    C.matrix[i][j] = this.matrix[i][j] + toAdd.matrix[i][j];
            return C;
        }
        return null;
    }

    //toString Method
    public String toString(){
        String returnString = "";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                returnString += Double.toString(matrix[i][j]) + " ";
            }
            returnString += System.lineSeparator();
        }
        returnString += System.lineSeparator();
        return returnString;
    }
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
}
