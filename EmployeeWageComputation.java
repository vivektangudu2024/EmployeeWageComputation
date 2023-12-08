package com.day3;

import java.util.Random;

public class EmployeeWageComputation {
    /*
     * @Desc : compute employee wage for a company
     * @Params: companyName, wagePerHour, fullDayHours, partTimeHours, totalWorkingDays, maxTotalWorkingHours
     */
    public static void computeEmployeeWage(String companyName, int wagePerHour, int fullDayHours,
                                           int partTimeHours, int totalWorkingDays, int maxTotalWorkingHours) {
        System.out.println("Welcome to " + companyName + " Employee Wage Computation Program");

        int totalWage = 0;
        int totalWorkingHours = 0;
        int daysWorked = 0;

        while (daysWorked < totalWorkingDays && totalWorkingHours < maxTotalWorkingHours) {
            int workingHours = checkAttendance(fullDayHours, partTimeHours);

            if (workingHours > 0) {
                System.out.println("Day " + (daysWorked + 1) + ": Employee is Present");

                int dailyWage = calculateDailyWage(wagePerHour, workingHours);
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

        System.out.println("Total Wage for the Month at " + companyName + ": " + totalWage);
        System.out.println("Total Working Hours at " + companyName + ": " + totalWorkingHours);
        System.out.println();
    }

    /*
     * @Desc : check employee attendance and return the number of working hours
     * @Params: fullTimeHours, partTimeHours
     * @returns: 0 for Absent, fullTimeHours for Full Time, partTimeHours for Part Time
     */
    private static int checkAttendance(int fullTimeHours, int partTimeHours) {
        Random random = new Random();
        int attendance = random.nextInt(3);

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

    /*
     * @Desc : display the type of work based on the number of working hours
     * @Params: hoursWorked
     */
    private static void displayTypeOfWork(int hoursWorked) {
        switch (hoursWorked) {
            case 8:
                System.out.println("Type of Work: Full Time");
                break;
            case 4:
                System.out.println("Type of Work: Part Time");
                break;
        }
    }

    public static void main(String[] args) {
        // Create objects for different companies and compute employee wages
        computeEmployeeWage("Company A", 25, 8, 4, 20, 100);
        computeEmployeeWage("Company B", 22, 8, 4, 25, 120);
    }
}