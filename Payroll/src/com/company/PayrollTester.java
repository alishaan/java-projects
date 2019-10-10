package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PayrollTester {

    public static void main(String[] args) throws IOException {
        Payroll testerPayroll = new Payroll(new File("employeeOutput.csv"));
        System.out.println(testerPayroll.getEmployeeArray().toString());
    }
}
