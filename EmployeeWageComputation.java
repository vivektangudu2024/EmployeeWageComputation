package com.day3;

import java.util.*;
public class EmployeeWageComputation {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        // Constants
        int wagePerHour = 20;
        int fullDayHours = 8;
        int partTimeHours = 4;
        int totalWorkingDays = 20;

        int totalWage = 0;

        for (int day = 1; day <= totalWorkingDays; day++) {
            // Calling the checkAttendance method to determine the type of work (full-time, part-time, or absent)
            int workingHours = checkAttendance(fullDayHours, partTimeHours);

            if (workingHours > 0) {
                System.out.println("Day " + day + ": Employee is Present");

                // Calculate daily wage based on the type of work
                int dailyWage = calculateDailyWage(wagePerHour, workingHours);
                System.out.println("Daily Employee Wage: " + dailyWage);

                // Accumulate the daily wage to the total wage
                totalWage += dailyWage;

                // Displaying the type of work
                switch (workingHours) {
                    case 8:
                        System.out.println("Type of Work: Full Time");
                        break;
                    case 4:
                        System.out.println("Type of Work: Part Time");
                        break;
                }
            } else {
                System.out.println("Day " + day + ": Employee is Absent");
            }
            System.out.println();
        }

        // Displaying the total wage for the month
        System.out.println("Total Wage for the Month: " + totalWage);
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
