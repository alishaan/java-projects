package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class PayrollTester {

    public static void main(String[] args) throws IOException {
        Payroll testPayroll = new Payroll();
        System.out.println(testPayroll.getEmployeeArray().toString());
    }
}
