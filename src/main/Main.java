package main;

import java.util.Scanner;
import model.Expense;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {

            try {

                System.out.println("\n================================");
                System.out.println("      EXPENSE TRACKER");
                System.out.println("================================");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. Update Expense");
                System.out.println("4. Delete Expense");
                System.out.println("5. Monthly Summary");
                System.out.println("6. Export Report");
                System.out.println("7. Exit");
                System.out.print("Enter Choice: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                case 1:

                    System.out.print("Enter Expense ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter Date: ");
                    String date = sc.nextLine();

                    Expense e = new Expense(id, title, category, amount, date);

                    e.addExpense();

                    break;

                case 2:

                    Expense.viewExpenses();

                    break;

                case 3:

                    System.out.print("Enter Expense ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();

                    System.out.print("Enter New Amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Enter New Date: ");
                    String newDate = sc.nextLine();

                    Expense.updateExpense(
                            updateId,
                            newTitle,
                            newCategory,
                            newAmount,
                            newDate);

                    break;

                case 4:

                    System.out.print("Enter Expense ID to Delete: ");
                    int deleteId = sc.nextInt();

                    Expense.deleteExpense(deleteId);

                    break;

                case 5:

                    System.out.println("Monthly Summary Module Under Development");

                    break;

                case 6:

                    System.out.println("Export Module Under Development");

                    break;

                case 7:

                    running = false;
                    System.out.println("Thank You For Using Expense Tracker!");

                    break;

                default:

                    System.out.println("Invalid Choice!");
                }

            } catch (Exception e) {

                System.out.println("Invalid Input. Please Try Again.");

                sc.nextLine();
            }
        }

        sc.close();
    }
}