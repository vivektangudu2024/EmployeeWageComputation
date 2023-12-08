package com.day3;

import java.util.ArrayList;
import java.util.Random;


interface IEmpWageBuilder {
    void addCompany(String companyName, int wagePerHour, int fullDayHours,
                    int partTimeHours, int totalWorkingDays, int maxTotalWorkingHours);

    void computeEmployeeWages();

    void displayTotalWages();
}

/*
 * @Desc : Employee wage Calculator class
 * @Methods : computeEmployeeWage, checkAttendance, calculateDailyWage
 */

class CompanyEmpWage {
    private final String companyName;
    private final int wagePerHour;
    private final int fullDayHours;
    private final int partTimeHours;
    private final int totalWorkingDays;
    private final int maxTotalWorkingHours;

    // Instance variables to store total wage and total working hours for each company
    private int totalWage = 0;
    private int totalWorkingHours = 0;

    // ArrayList to store daily wages
    private final ArrayList<Integer> dailyWages = new ArrayList<>();

    // Constructor to initialize company-specific details
    public CompanyEmpWage(String companyName, int wagePerHour, int fullDayHours,
                          int partTimeHours, int totalWorkingDays, int maxTotalWorkingHours) {
        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.fullDayHours = fullDayHours;
        this.partTimeHours = partTimeHours;
        this.totalWorkingDays = totalWorkingDays;
        this.maxTotalWorkingHours = maxTotalWorkingHours;
    }

    // Method to compute employee wages for the company
    public void computeEmployeeWage() {
        System.out.println("Welcome to " + companyName + " Employee Wage Computation Program");

        int daysWorked = 0;

        while (daysWorked < totalWorkingDays && totalWorkingHours < maxTotalWorkingHours) {
            int workingHours = checkAttendance();

            if (workingHours > 0) {
                System.out.println("Day " + (daysWorked + 1) + ": Employee is Present");

                int dailyWage = calculateDailyWage(workingHours);
                System.out.println("Daily Employee Wage: " + dailyWage);

                // Store the daily wage in the list
                dailyWages.add(dailyWage);

                totalWage += dailyWage;
                totalWorkingHours += workingHours;

                displayTypeOfWork(workingHours);
            } else {
                System.out.println("Day " + (daysWorked + 1) + ": Employee is Absent");
            }

            daysWorked++;

            System.out.println();
        }

        // Displaying the total wage and total working hours
        System.out.println("Total Wage for the Month at " + companyName + ": " + totalWage);
        System.out.println("Total Working Hours at " + companyName + ": " + totalWorkingHours);

        // Displaying the list of daily wages
        System.out.println("Daily Wages at " + companyName + ": " + dailyWages);
        System.out.println();
    }


    /*
     * @Desc : check employee attendance and return the number of working hours
     * @returns: 0 for Absent, fullDayHours for Full Time, partTimeHours for Part Time
     */
    private int checkAttendance() {
        Random random = new Random();
        int attendance = random.nextInt(3);

        switch (attendance) {
            case 0:
                return 0; // Absent
            case 1:
                return fullDayHours; // Full Time
            case 2:
                return partTimeHours; // Part Time
            default:
                return 0; // Absent (default case)
        }
    }

    /*
     * @Desc : calculate daily wage
     * @Params: hoursWorked
     * @returns: daily wage
     */
    private int calculateDailyWage(int hoursWorked) {
        return wagePerHour * hoursWorked;
    }

    /*
     * @Desc : display the type of work based on the number of working hours
     * @Params: hoursWorked
     */
    private void displayTypeOfWork(int hoursWorked) {
        switch (hoursWorked) {
            case 8:
                System.out.println("Type of Work: Full Time");
                break;
            case 4:
                System.out.println("Type of Work: Part Time");
                break;
        }
    }

    //@desc: Getter method to retrieve the total wage for reporting
    public int getTotalWage() {
        return totalWage;
    }

    //@desc: Getter method to retrieve the total wage for reporting
    public String getCompanyName() {
        return companyName;
    }
}
public class EmployeeWageComputation implements IEmpWageBuilder{
    private final ArrayList<CompanyEmpWage> companyEmpWages;

    public EmployeeWageComputation() {
        this.companyEmpWages = new ArrayList<>();
    }

    public void addCompany(String companyName, int wagePerHour, int fullDayHours,
                           int partTimeHours, int totalWorkingDays, int maxTotalWorkingHours) {
        companyEmpWages.add(new CompanyEmpWage(companyName, wagePerHour, fullDayHours,
                partTimeHours, totalWorkingDays, maxTotalWorkingHours));
    }

    public void computeEmployeeWages() {
        for (CompanyEmpWage companyEmpWage : companyEmpWages) {
            companyEmpWage.computeEmployeeWage();
        }
    }

    public void displayTotalWages() {
        for (CompanyEmpWage companyEmpWage : companyEmpWages) {
            System.out.println("Total Wage for the Month at " + companyEmpWage.getCompanyName() +
                    ": " + companyEmpWage.getTotalWage());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        EmployeeWageComputation empWageBuilder = new EmployeeWageComputation();

        empWageBuilder.addCompany("Company A", 25, 8, 4, 20, 100);
        empWageBuilder.addCompany("Company B", 22, 8, 4, 25, 120);

        empWageBuilder.computeEmployeeWages();
        empWageBuilder.displayTotalWages();
    }
}