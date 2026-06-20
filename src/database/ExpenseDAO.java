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

        } catch (Exception e)
        {
            System.out.println("Failed to Add Expense!");
        }

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
}
    public static void updateExpense(int id,
            String title,
            String category,
            double amount,
            String date)
    {
        String sql =
                "UPDATE expenses SET title=?, category=?, amount=?, date=? WHERE id=?";

        try
        {
            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, category);
            ps.setDouble(3, amount);
            ps.setString(4, date);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                System.out.println("Expense Updated Successfully!");
            }
            else
            {
                System.out.println("Expense Not Found, unable to perform updation\nExiting update...3");
            }

            ps.close();
            con.close();
        }

        catch(Exception e)
        {
            System.out.println("Failed to Update Expense");
            e.printStackTrace();
        }
    }
    public static void deleteExpense(int id)
    {
        String sql =
                "DELETE FROM expenses WHERE id=?";

        try
        {
            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);
            System.out.println("Deleting ID = " + id);
            int rows = ps.executeUpdate();

            if(rows > 0)
            {
                System.out.println("Expense Deleted Successfully!");
            }
            else
            {
                System.out.println("Expense Not Found!");
            }

            ps.close();
            con.close();
        }

        catch(Exception e)
        {
            System.out.println("Failed to Delete Expense");
            e.printStackTrace();
        }
    }
    public static boolean idExists(int id)
    {
        String sql = "SELECT id FROM expenses WHERE id=?";

        try
        {
            Connection con = DBconnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            boolean exists = rs.next();

            rs.close();
            ps.close();
            con.close();

            return exists;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
}