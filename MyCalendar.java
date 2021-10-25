// William Greiner
// 10/24/21
// CS 141
// Assignment 1

import java.util.Scanner;
import java.util.Calendar;

// This program will display the calendar from
// the month and date of your choosing as well 
// as the current month and date.
public class MyCalendar {

    public static final int SIZE = 15;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Calendar myCal = Calendar.getInstance();
        int currentDay = myCal.get(Calendar.DATE);
        int currentMonth = myCal.get(Calendar.MONTH) + 1;
        System.out.println("What date would you like to look at? (mm/dd)");
        String user = console.next();
        drawMonth(monthFromDate(user));
        displayDate(monthFromDate(user), dayFromDate(user));
        System.out.println("\nThis month:");
        drawMonth(currentMonth);
        displayDate(currentMonth, currentDay);
    }

    // Takes a month and displays a graphical
    // representation of a calendar for that month.
    public static void drawMonth(int month) {
        for (int i = 1; i <= SIZE / 2 + 1; i++) {
            System.out.print("'-._.-");
        }
        System.out.print("`[" + month + "]`");
        for (int i = 1; i <= SIZE / 2 + 1; i++) {
            System.out.print("-._.-`");
        }
        System.out.println();
        for (int i = 1; i <= 5; i++) {
            drawRow(i);
        }
        for (int i = 1; i <= 7; i++) {
            System.out.print(".");
            for (int j = 1; j <= SIZE; j++) {
                System.out.print("~");
            }
        }
        System.out.println(".");
    }

    // Takes a day and displays the calendar week of that day.
    public static void drawRow(int row) {
        for (int i = 1; i <= 7; i++) {
            System.out.print(".");
            for (int j = 1; j <= SIZE; j++) {
                System.out.print("~");
            }
        }
        System.out.println(".");
        for (int i = 1; i <= 7; i++) {

            // Calculates the dates for a specific week or row.
            int dateCalculator = (i + (row - 1) * 7);

            // Calculates the amount of digits in the number we got from the date calculator.
            int digitCounter = (int) Math.floor(Math.log10(dateCalculator)) + 1;
            System.out.print(":" + dateCalculator);
            for (int j = 1; j <= SIZE - (digitCounter); j++) {
                System.out.print(" ");
            }
        }
        System.out.println(":");
        for (int i = 1; i <= SIZE / 5; i++) {
            for (int j = 1; j <= 7; j++) {
                System.out.print(":");
                for (int k = 1; k <= SIZE; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println(":");
        }
    }

    // Takes the month and day and displays that information
    // underneath the graphical representation of the calendar.
    public static void displayDate(int month, int day) {
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
    }

    // Takes a date, extracts the month from that date, and returns it in integer form.
    public static int monthFromDate(String date) {
        String month = date.substring(0, date.indexOf("/"));
        return Integer.parseInt(month);
    }

    // Takes a date, extracts the day from that date, and returns it in integer form.
    public static int dayFromDate(String date) {
        String day = date.substring(date.indexOf("/") + 1);
        return Integer.parseInt(day);
    }
}