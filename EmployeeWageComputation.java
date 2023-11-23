package com.day3;

import java.util.*;
public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        // Constants
        int wagePerHour = 20;
        int fullDayHours = 8;
        int partTimeHours = 4;

        // Calling the checkAttendance method to determine the type of work (full-time, part-time, or absent)
        int workingHours = checkAttendance(fullDayHours, partTimeHours);

        if (workingHours > 0) {
            System.out.println("Employee is Present");



            // Displaying the type of work
            if (workingHours == fullDayHours) {
                System.out.println("Type of Work: Full Time");
            } else {
                System.out.println("Type of Work: Part Time");
            }
        } else {
            System.out.println("Employee is Absent");
        }

        // Calculate daily wage based on the type of work
        int dailyWage = calculateDailyWage(wagePerHour, workingHours);
        System.out.println("Daily Employee Wage: " + dailyWage);
    }

    /*
     * @Desc : check employee attendance and return the number of working hours
     * @Params: fullTimeHours, partTimeHours
     * @returns: 0 for Absent, fullTimeHours for Full Time, partTimeHours for Part Time
     */
    public static int checkAttendance(int fullTimeHours, int partTimeHours) {
        // Creating an instance of Random class
        Random random = new Random();

        // Generating a random number (0, 1, or 2) representing attendance
        int attendance = random.nextInt(3);

        // Returning the number of working hours based on the attendance value
        switch (attendance) {
            case 0:
                return 0; // Absent
            case 1:
                return fullTimeHours; // Full Time
            case 2:
                return partTimeHours; // Part Time
            default:
                return 0; // Absent (default case)
        }
    }

    /*
     * @Desc : calculate daily wage
     * @Params: wagePerHour, hoursWorked
     * @returns: daily wage
     */
    private static int calculateDailyWage(int wagePerHour, int hoursWorked) {
        return wagePerHour * hoursWorked;
    }
}
