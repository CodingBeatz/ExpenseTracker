package service;
import java.util.Scanner;
public class SummaryService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("EXPENSE SUMMARY MENU");
		System.out.println("1. Monthly Expense Summary");
		System.out.println("2. Yearly  Expense Summary");
		System.out.println("Enter the choice:");
		int choice=sc.nextInt();
		if (choice==1) {
			System.out.println("Enter the month for the summary:");
			int month=sc.nextInt();
			if(month<1||month>12) {
				System.out.println("Invalid month");
			    return;
			}
			System.out.println("Enter the year:");
			int year=sc.nextInt();
			if(year<1) {
			System.out.println("Invalid year");
			return;
			}
			System.out.println("MONTHLY EXPENSE SUMMARY");
			System.out.println("Month:"+month);
			System.out.println("Year:"+year);
			System.out.println("Total Expenses:");
		}
		else if(choice==2) {
			System.out.println("Enter the year for summary:");
			int year=sc.nextInt();
			if(year<1) {
				System.out.println("Invalid year");
				return;
				}
			System.out.println("YEARLY EXPENSE SUMMARY");
			System.out.println("Year:"+year);
			System.out.println("Total Expenses:");
		}
		else {
			System.out.println("Invalid Choice");
		}	
		}
	}


