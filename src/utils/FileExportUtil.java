package utils;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import database.DBconnection;
public class FileExportUtil {
	public static void exportReport(double total,String details) {
		try {
            Connection con = DBconnection.getConnection();
				String sql="SELECT*FROM expenses";

	            PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
				FileWriter writer=new FileWriter("Expense_Report.txt");
				
				writer.write("===========================\n");
				writer.write("       EXPENSE REPORT\n");
				writer.write("===========================\n\n");
				writer.write(" FULL EXPENSE DETAILS \n\n");
				
				double databaseTotal=0;
				while (rs.next()) {
					writer.write("ID   :"+rs.getInt("id")+"\n");
				    writer.write("Title :"+rs.getString("title")+"\n");
				    writer.write("Category :"+rs.getString("category")+"\n");
				    writer.write("Amount :"+rs.getDouble("amount")+"\n");
				    writer.write("Date:"+rs.getString("date")+"\n");
				    writer.write("--------------------------\n");
				    databaseTotal+= rs.getDouble("amount");
				}
				writer.write("\nTotal Database Expense:₹"+databaseTotal);
			    

			writer.write("==============================\n");
			writer.write("       SUMMARY REPORT\n");
			writer.write("============================\n\n");
			 writer.write(details+"\n");
			 writer.write("Selected Summary total:₹"+total);
			 writer.close();
         	    rs.close();
			    ps.close();
			    con.close();
			
			 System.out.println("Report Exported Successfully!");			
		}
		catch(Exception e) {
			   System.out.println("Export Failed");
			   e.printStackTrace();	
	}
	}
}


	