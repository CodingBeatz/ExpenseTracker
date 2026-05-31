package main;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("================================\r\n"
				+ "      EXPENSE TRACKER\r\n"
				+ "================================\r\n"
				+ "\r\n"
				+ "1. Add Expense\r\n"
				+ "2. View Expenses\r\n"
				+ "3. Update Expense\r\n"
				+ "4. Delete Expense\r\n"
				+ "5. Monthly Summary\r\n"
				+ "6. Export Report\r\n"
				+ "7. Exit\r\n"
				+ "\r\n"
				+ "Enter Choice:");
		Scanner SC = new Scanner(System.in);
		int choice = SC.nextInt();
		if(choice == 1)
		{
		    System.out.println("Add Expense Selected");
		}
		else if(choice == 2)
		{
		    System.out.println("View Expense Selected");
		}
		else if(choice == 3)
		{
		    System.out.println("Update Expense Selected");
		}
		else if(choice == 4)
		{
		    System.out.println("Delete Expense Selected");
		}
		else if(choice == 5)
		{
		    System.out.println("Monthly Summary Selected");
		}
		else if(choice == 6)
		{
		    System.out.println("Export Report Selected");
		}
		else if(choice == 7)
		{
		    System.out.println("Exiting...");
		}
		else
		{
		    System.out.println("Invalid Choice");
		}
	}

}
