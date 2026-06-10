package service;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DBconnection;

public class SummaryService {

    public static void showSummary() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== EXPENSE SUMMARY MENU =====");
        System.out.println("1. Monthly Expense Summary");
        System.out.println("2. Yearly Expense Summary");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();

        if (choice == 1) {

            System.out.print("Enter Month (MM): ");
            int month = sc.nextInt();

            System.out.print("Enter Year (YYYY): ");
            int year = sc.nextInt();

            double total = 0;

            try {

                Connection con = DBconnection.getConnection();

                String sql =
                        "SELECT SUM(amount) FROM expenses WHERE substr(date,4,2)=? AND substr(date,7,4)=?";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, String.format("%02d", month));
                ps.setString(2, String.valueOf(year));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    total = rs.getDouble(1);
                }

                System.out.println("\n===== MONTHLY SUMMARY =====");
                System.out.println("Month : " + month);
                System.out.println("Year  : " + year);
                System.out.println("Total Expenses : ₹" + total);

                rs.close();
                ps.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        else if (choice == 2) {

            System.out.print("Enter Year (YYYY): ");
            int year = sc.nextInt();

            double total = 0;

            try {

                Connection con = DBconnection.getConnection();

                String sql =
                        "SELECT SUM(amount) FROM expenses WHERE substr(date,7,4)=?";

                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, String.valueOf(year));

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    total = rs.getDouble(1);
                }

                System.out.println("\n===== YEARLY SUMMARY =====");
                System.out.println("Year : " + year);
                System.out.println("Total Expenses : ₹" + total);

                rs.close();
                ps.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        else {

            System.out.println("Invalid Choice!");

        }

    }

}