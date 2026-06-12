package utils;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DBconnection;
public class FileExportUtil {
	public static void exportFile() {
		try {
            Connection con = DBconnection.getConnection();
				String sql="SELECT*FROM expenses";

	            PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				FileWriter writer=new FileWriter("Expense_Report.txt");
				
				writer.write("===========================\n");
				writer.write("       EXPENSE REPORT\n");
				writer.write("===========================\n\n");
				double total=0;
				while (rs.next()) {
					writer.write("ID   :"+rs.getInt("id")+"\n");
				    writer.write("Title :"+rs.getString("title")+"\n");
				    writer.write("Category :"+rs.getString("category")+"\n");
				    writer.write("Amount :"+rs.getDouble("amount")+"\n");
				    writer.write("Date:"+rs.getString("date")+"\n");
				    writer.write("--------------------------\n");
				    total=total + rs.getDouble("amount");
				}
			    writer.write("\nTotal Expense:₹"+total);
			    writer.close();
			    System.out.println("Report Exported Successfully!");
			    rs.close();
			    ps.close();
			    con.close();
			}catch(Exception e) {
				   System.out.println("Export Failed");
				   e.printStackTrace();
				
		}
	}
}


	