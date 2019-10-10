package com.company;

import java.io.*;
import java.util.ArrayList;

public class Payroll {
    private ArrayList<PayrollEmployee> employeeArray = new ArrayList<PayrollEmployee>();

    //Default constructor generates an array of 100 employees and the corresponding output file
    public Payroll() throws IOException {
        FileWriter employeeListWriter = new FileWriter(new File("employeeOutput.csv"));
        PrintWriter writer = new PrintWriter(employeeListWriter);
        String randomEmployeeArrayString = "";
        for(int i = 0; i<100; i++){
            PayrollEmployee randomEmployee = new PayrollEmployee();
            employeeArray.add(randomEmployee);
            randomEmployeeArrayString = randomEmployeeArrayString +employeeArray.get(i) + System.lineSeparator();
        }
        writer.println("LAST_NAME, FIRST_NAME, ID_NUMBER, HOURS_WORKED, RATE, AGE, SEX, NICK_NAME, DEPENDENTS, GROSS_PAY, OVERTIME");
        writer.print(randomEmployeeArrayString);
        employeeListWriter.close();
    }

    //Fill Constructor will take in a file and generate an array of employees from it
    public Payroll(File passedFile) throws IOException {
        int passedFileLengthInt = 0;
        try {
            LineNumberReader passedFileLength = new LineNumberReader(new FileReader(passedFile));
            while (passedFileLength.readLine() != null) {
                passedFileLengthInt++;
            }
            passedFileLength.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        //remove one for the header
        passedFileLengthInt -= 1;

        //open up the passed file and loop through the header
        LineNumberReader passedFileReader = new LineNumberReader(new FileReader(passedFile));
        passedFileReader.readLine();

        //loop through the employees in the csv file
        for(int i=0; i<passedFileLengthInt; i++){
            //read the line and store it to main string
            String readString = passedFileReader.readLine();
            //split into array by finding of ", "
            String[] attributes = readString.split(", ");
            //take array and pass it into new PayrollEmployee
            String firstName = attributes[1];
            String lastName = attributes[0];
            int idNum = Integer.parseInt(attributes[2]);
            int hoursWorked = Integer.parseInt(attributes[3]);
            double rateDouble = Double.parseDouble(attributes[4]);
            int age = Integer.parseInt(attributes[5]);
            int numDependents = Integer.parseInt(attributes[8]);
            String sex = attributes[6];

            //create new payroll employee
            PayrollEmployee payrollEmployee = new PayrollEmployee(firstName, lastName, idNum, hoursWorked, rateDouble, age, numDependents, sex);

            //add employee to the array
            employeeArray.add(payrollEmployee);

        }
    }

    public ArrayList<PayrollEmployee> getEmployeeArray() {
        return employeeArray;
    }

    public void setEmployeeArray(ArrayList<PayrollEmployee> employeeArray) {
        this.employeeArray = employeeArray;
    }
}

