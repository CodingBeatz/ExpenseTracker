package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBconnection {

    private static final String URL = "jdbc:sqlite:expense.db";

    public static Connection getConnection() {

        try {

            Class.forName("org.sqlite.JDBC");

            Connection con = DriverManager.getConnection(URL);
           

            Statement stmt = con.createStatement();

            stmt.execute(
                    "CREATE TABLE IF NOT EXISTS expenses (" +
                    "id INTEGER PRIMARY KEY," +
                    "title TEXT NOT NULL," +
                    "category TEXT NOT NULL," +
                    "amount REAL NOT NULL," +
                    "date TEXT NOT NULL" +
                    ");");

           

            return con;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        }

    }
    public static void main(String[] args) {
        Connection con = getConnection();

        if (con != null) {
            System.out.println("Database Ready!");
        }

    }

}