package main;

import java.util.Scanner;
import utils.ValidationUtil;
import model.Expense;
import service.SummaryService;
import database.DBconnection;
import java.sql.Connection;
import database.ExpenseDAO;
import database.ExpenseDAO;
public class Main {

    public static void main(String[] args) {
    	

    	    Connection con = DBconnection.getConnection();

    	    if (con == null) {
    	        System.out.println("Database Connection Failed!");
    	        return;
    	    }

    	   
    	

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

                    if (!ValidationUtil.isValidId(id))
                        break;

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    if (!ValidationUtil.isValidTitle(title))
                        break;

                    System.out.print("Enter Category: ");
                    String category = sc.nextLine();

                    if (!ValidationUtil.isValidCategory(category))
                        break;

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine();

                    if (!ValidationUtil.isValidAmount(amount))
                        break;

                    System.out.print("Enter Date: ");
                    String date = sc.nextLine();

                    if (!ValidationUtil.isValidDate(date))
                        break;

                    Expense e =
                    		new Expense(id,title,category,amount,date);

                    		ExpenseDAO.addExpense(e);
                    break;

                case 2:

                	ExpenseDAO.viewExpenses();
                    break;

                case 3:

                    System.out.print("Enter Expense ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    if (!ValidationUtil.isValidId(updateId))
                        break;

                    System.out.print("Enter New Title: ");
                    String newTitle = sc.nextLine();

                    if (!ValidationUtil.isValidTitle(newTitle))
                        break;

                    System.out.print("Enter New Category: ");
                    String newCategory = sc.nextLine();

                    if (!ValidationUtil.isValidCategory(newCategory))
                        break;

                    System.out.print("Enter New Amount: ");
                    double newAmount = sc.nextDouble();
                    sc.nextLine();

                    if (!ValidationUtil.isValidAmount(newAmount))
                        break;

                    System.out.print("Enter New Date: ");
                    String newDate = sc.nextLine();

                    if (!ValidationUtil.isValidDate(newDate))
                        break;

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

                	SummaryService.showSummary();

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