package com.day3;

import java.util.*;
public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        // Calling the checkAttendance method to determine if the employee is present or absent
        if (checkAttendance()) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }

    /*
    * @Desc : check employee attendance using a random number
    * @Params: 0
    * @returns: Present/Absent
    */
    public static boolean checkAttendance() {
        // Creating an instance of Random class
        Random random = new Random();

        // Generating a random number (0 or 1) representing attendance (0 for absent, 1 for present)
        int attendance = random.nextInt(2);

        // Returning true if attendance is 1 (present), false otherwise
        return attendance == 1;
    }
}
