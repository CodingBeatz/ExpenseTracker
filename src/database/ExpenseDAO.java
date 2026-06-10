package database;

import java.sql.Connection;
import java.sql.PreparedStatement;


import model.Expense;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpenseDAO {

    public static void addExpense(Expense expense) {

        String sql =
                "INSERT INTO expenses(id,title,category,amount,date) VALUES(?,?,?,?,?)";

        try {

            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, expense.getId());
            ps.setString(2, expense.getTitle());
            ps.setString(3, expense.getCategory());
            ps.setDouble(4, expense.getAmount());
            ps.setString(5, expense.getDate());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense Added Successfully!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("Failed to Add Expense");
            e.printStackTrace();        }

    }
    
    public static void viewExpenses()
    {
        String sql = "SELECT * FROM expenses";

        try
        {
            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========================================");
            System.out.println("             EXPENSE LIST");
            System.out.println("========================================");

            boolean found = false;

            while(rs.next())
            {
                found = true;

                System.out.println("ID       : " + rs.getInt("id"));
                System.out.println("Title    : " + rs.getString("title"));
                System.out.println("Category : " + rs.getString("category"));
                System.out.println("Amount   : ₹" + rs.getDouble("amount"));
                System.out.println("Date     : " + rs.getString("date"));
                System.out.println("----------------------------------------");
            }

            if(!found)
            {
                System.out.println("No Expenses Found");
            }

            rs.close();
            ps.close();
            con.close();
        }

        catch(Exception e)
        {
            System.out.println("Failed to View Expenses");
            e.printStackTrace();
        }
}}