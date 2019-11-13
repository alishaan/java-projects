package com.company;

public class MatrixTester {

    public static void main(String[] args) {
        Matrix badMatrix = new Matrix(5, 5);
        double[][] original = {{3,2,4,5}, {2, 1, 3, 5}, {3.3, 5, 2, 6}, {9, 5, 6, 7}};
        Matrix startMatrix = new Matrix(original);

        System.out.println(badMatrix.canAdd(startMatrix));

        System.out.print(startMatrix.toString());

        double[][] toCreate = {{1,2,4,5}, {9, 1, 3, 5}, {3.3, 5, 2, 6}, {12, 5, 6, 7}};
        Matrix toAdd = new Matrix(toCreate);

        System.out.print(toAdd.toString());

        System.out.println(startMatrix.add(toAdd).toString());;

        System.out.println(startMatrix.add(badMatrix));

    }
}
