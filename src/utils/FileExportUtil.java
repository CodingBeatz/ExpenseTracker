package utils;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import database.DBconnection;

public class FileExportUtil {

    public static void exportReport() {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n===== EXPORT REPORT =====");
        System.out.println("1. Monthly Report");
        System.out.println("2. Yearly Report");
        System.out.print("Enter Choice: ");

        int choice = sc.nextInt();

        String sql = "";
        String heading = "";
        String totalSql = "";

        try {

            Connection con = DBconnection.getConnection();

            PreparedStatement ps;
            PreparedStatement totalPs;

            if (choice == 1) {

                System.out.print("Enter Month (MM): ");
                int month = sc.nextInt();

                System.out.print("Enter Year (YYYY): ");
                int year = sc.nextInt();

                sql =
                        "SELECT * FROM expenses WHERE substr(date,4,2)=? AND substr(date,7,4)=?";

                totalSql =
                        "SELECT SUM(amount) FROM expenses WHERE substr(date,4,2)=? AND substr(date,7,4)=?";

                ps = con.prepareStatement(sql);
                totalPs = con.prepareStatement(totalSql);

                String m = String.format("%02d", month);
                String y = String.valueOf(year);

                ps.setString(1, m);
                ps.setString(2, y);

                totalPs.setString(1, m);
                totalPs.setString(2, y);

                heading =
                        "MONTHLY EXPENSE REPORT\nMonth : "
                                + month +
                                "\nYear : "
                                + year;

            }

            else if (choice == 2) {

                System.out.print("Enter Year (YYYY): ");
                int year = sc.nextInt();

                sql =
                        "SELECT * FROM expenses WHERE substr(date,7,4)=?";

                totalSql =
                        "SELECT SUM(amount) FROM expenses WHERE substr(date,7,4)=?";

                ps = con.prepareStatement(sql);
                totalPs = con.prepareStatement(totalSql);

                String y = String.valueOf(year);

                ps.setString(1, y);
                totalPs.setString(1, y);

                heading =
                        "YEARLY EXPENSE REPORT\nYear : "
                                + year;

            }

            else {

                System.out.println("Invalid Choice!");
                con.close();
                return;

            }

            ResultSet rs = ps.executeQuery();
            ResultSet totalRs = totalPs.executeQuery();

            double total = 0;

            if (totalRs.next()) {
                total = totalRs.getDouble(1);
            }

            FileWriter writer =
                    new FileWriter("Expense_Report.txt");

            writer.write("====================================\n");
            writer.write(heading + "\n");
            writer.write("====================================\n\n");

            while (rs.next()) {

                writer.write("ID       : "
                        + rs.getInt("id") + "\n");

                writer.write("Title    : "
                        + rs.getString("title") + "\n");

                writer.write("Category : "
                        + rs.getString("category") + "\n");

                writer.write("Amount   : ₹"
                        + rs.getDouble("amount") + "\n");

                writer.write("Date     : "
                        + rs.getString("date") + "\n");

                writer.write("------------------------------------\n");

            }

            writer.write("\nTotal Expense : ₹" + total);

            writer.close();

            rs.close();
            totalRs.close();
            ps.close();
            totalPs.close();
            con.close();

            System.out.println("Report Exported Successfully!");

        }

        catch (Exception e) {

            System.out.println("Export Failed");
            e.printStackTrace();

        }

    }

}