package com.day3;

import java.util.Random;

public class EmployeeWageComputation {
    // Constants
    private static final int WAGE_PER_HOUR = 20;
    private static final int FULL_DAY_HOURS = 8;
    private static final int PART_TIME_HOURS = 4;
    private static final int TOTAL_WORKING_DAYS = 20;
    private static final int MAX_TOTAL_WORKING_HOURS = 100;

    // Class variables
    private static int totalWage = 0;
    private static int totalWorkingHours = 0;
    private static int daysWorked = 0;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");
        computeEmployeeWage();
    }

    /*
     * @Desc : compute employee wage using class methods and class variables
     */
    public static void computeEmployeeWage() {
        while (daysWorked < TOTAL_WORKING_DAYS && totalWorkingHours < MAX_TOTAL_WORKING_HOURS) {
            int workingHours = checkAttendance();

            if (workingHours > 0) {
                System.out.println("Day " + (daysWorked + 1) + ": Employee is Present");

                int dailyWage = calculateDailyWage(workingHours);
                System.out.println("Daily Employee Wage: " + dailyWage);

                totalWage += dailyWage;
                totalWorkingHours += workingHours;

                displayTypeOfWork(workingHours);
            } else {
                System.out.println("Day " + (daysWorked + 1) + ": Employee is Absent");
            }

            daysWorked++;

            System.out.println();
        }

        System.out.println("Total Wage for the Month: " + totalWage);
        System.out.println("Total Working Hours: " + totalWorkingHours);
    }

    /*
     * @Desc : check employee attendance and return the number of working hours
     * @returns: 0 for Absent, FULL_DAY_HOURS for Full Time, PART_TIME_HOURS for Part Time
     */
    private static int checkAttendance() {
        Random random = new Random();
        int attendance = random.nextInt(3);

        switch (attendance) {
            case 0:
                return 0; // Absent
            case 1:
                return FULL_DAY_HOURS; // Full Time
            case 2:
                return PART_TIME_HOURS; // Part Time
            default:
                return 0; // Absent (default case)
        }
    }

    /*
     * @Desc : calculate daily wage
     * @Params: hoursWorked
     * @returns: daily wage
     */
    private static int calculateDailyWage(int hoursWorked) {
        return WAGE_PER_HOUR * hoursWorked;
    }

    /*
     * @Desc : display the type of work based on the number of working hours
     * @Params: hoursWorked
     */
    private static void displayTypeOfWork(int hoursWorked) {
        switch (hoursWorked) {
            case FULL_DAY_HOURS:
                System.out.println("Type of Work: Full Time");
                break;
            case PART_TIME_HOURS:
                System.out.println("Type of Work: Part Time");
                break;
        }
    }
}