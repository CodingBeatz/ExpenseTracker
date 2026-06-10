package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Expense;

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
            e.printStackTrace();

        }

    }

}