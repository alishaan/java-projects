package com.company;

public class Matrix {
    private double[][] matrix;

    //creates matrix of 0's with a dimension
    public Matrix (int r, int c){
        matrix = new double[r][c];
    }

    //fill in by passing in a two dimensional array of values
    public Matrix(double[][] data){
        int rows = data.length;
        int columns = data[0].length;
        matrix = new double[rows][columns];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix[i][j] = data[i][j];
    }

    //Copy Constructor
    public Matrix(Matrix toCopy){
        matrix = toCopy.matrix;
    }

    //check if it can add or subtract
    public boolean canAdd(Matrix toAdd){
        if (toAdd.matrix.length != this.matrix.length || toAdd.matrix[0].length != this.matrix[0].length){
            return false;
        }else{
            return true;
        }
    }

    //Function to add matrices
    public Matrix add(Matrix toAdd){
        if (canAdd(toAdd)){
            int rows = matrix.length;
            int columns = matrix[0].length;
            Matrix C = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++)
                    C.matrix[i][j] = this.matrix[i][j] + toAdd.matrix[i][j];
            return C;
        }
        return null;
    }

    //Function to subtract
    public Matrix subtract(Matrix toSubtract){
        if (canAdd(toSubtract)){
            int rows = matrix.length;
            int columns = matrix[0].length;
            Matrix C = new Matrix(rows, columns);
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < columns; j++)
                    C.matrix[i][j] = this.matrix[i][j] - toSubtract.matrix[i][j];
            return C;
        }
        return null;
    }

    //Function to check if two matrices can be multiplied
    public boolean checkMult(Matrix toMult){
        if (getColumns() != toMult.getRows()){
            return true;
        }
        return false;
    }

    //Function to multiply two matrices
    public Matrix multiply(Matrix toMult){
        if (checkMult(toMult)){
            Matrix toReturn = new Matrix(getRows(), toMult.getColumns());
            for (int i = 0; i < toReturn.getRows(); i++){
                for (int j = 0; j < toReturn.getColumns(); j++){
                    for (int k = 0; k <getColumns(); k++){
                        toReturn.matrix[i][j] += (matrix[i][k] * toMult.matrix[k][j]);
                    }
                }
            }
            return toReturn;
        }
        return null;
    }

    //toString Method
    public String toString(){
        String returnString = "";
        int rows = matrix.length;
        int columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                returnString += matrix[i][j] + " ";
            }
            returnString += System.lineSeparator();
        }
        return returnString;
    }

    //Getters and setters
    public int getRows(){
        return matrix.length;
    }
    public int getColumns(){
        return matrix[0].length;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
}
