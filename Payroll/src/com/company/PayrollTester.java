package com.company;

import java.io.IOException;
import java.util.Arrays;

public class PayrollTester {

    public static void main(String[] args) throws IOException {
        Payroll testPayroll = new Payroll();
        System.out.println(Arrays.toString(testPayroll.getEmployeeArray()));
    }
}
