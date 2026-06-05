package service;

import java.util.ArrayList;
import java.util.Scanner;
import service.SummaryService;

import model.Expense;

public class SummaryService {

    public static void showSummary()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== EXPENSE SUMMARY MENU =====");
        System.out.println("1. Monthly Expense Summary");
        System.out.println("2. Yearly Expense Summary");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();

        ArrayList<Expense> expenses =
                Expense.getExpenses();

        if(choice == 1)
        {
            System.out.print("Enter Month (MM): ");
            int month = sc.nextInt();

            System.out.print("Enter Year (YYYY): ");
            int year = sc.nextInt();

            double total = 0;

            for(Expense e : expenses)
            {
                String date = e.getDate();

                String[] parts = date.split("-");

                int expenseMonth =
                        Integer.parseInt(parts[1]);

                int expenseYear =
                        Integer.parseInt(parts[2]);

                if(expenseMonth == month
                        && expenseYear == year)
                {
                    total += e.getAmount();
                }
            }

            System.out.println("\n===== MONTHLY SUMMARY =====");
            System.out.println("Month : " + month);
            System.out.println("Year  : " + year);
            System.out.println("Total Expenses : ₹" + total);
        }

        else if(choice == 2)
        {
            System.out.print("Enter Year: ");

            int year = sc.nextInt();

            double total = 0;

            for(Expense e : expenses)
            {
                String[] parts =
                        e.getDate().split("-");

                int expenseYear =
                        Integer.parseInt(parts[2]);

                if(expenseYear == year)
                {
                    total += e.getAmount();
                }
            }

            System.out.println("\n===== YEARLY SUMMARY =====");
            System.out.println("Year : " + year);
            System.out.println("Total Expenses : ₹" + total);
        }

        else
        {
            System.out.println("Invalid Choice");
        }
    }
}