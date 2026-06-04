package model;
import java.util.ArrayList;
public class Expense {

    private int id;
    private String title;
    private String category;
    private double amount;
    private String date;
    private static ArrayList<Expense>expenses=new ArrayList<Expense>();
	public Expense(int id, String title, String category, double amount, String date) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.amount = amount;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	//ADD
	public void addExpense() {
		expenses.add(this);
		System.out.println("Expense Added successfully");}
	//VIEW
	public static void viewExpenses() {
		if(expenses.isEmpty())
		{
			System.out.println("No Expenses Found");
			return;}
		
	for(Expense e : expenses) {
		System.out.println(e);}
	}

//DELETE
public static void deleteExpense(int id)
{
	for(int i=0;i<expenses.size();i++) {
		if(expenses.get(i).getId()==id)
		{
			expenses.remove(i);
			System.out.println("Expense Deleted Successfully");
			return;}
		}
	System.out.println("Expense Not Found");
	}
	//UPDATE
public static void updateExpense(int id,String title,String category,double amount,String date)
{
	for(Expense e: expenses)
	{
		if(e.getId()==id) {
			e.setTitle(title);
			e.setCategory(category);
			e.setAmount(amount);
			e.setDate(date);
			System.out.println("Expense Updated Successfully");
			return;
		}
	}
	System.out.println("Expense Not Found");
}
	
	@Override
	public String toString() {
		return "Expense [id=" + id + ", title=" + title + ", category=" + category + ", amount=" + amount + ", date="
				+ date + "]";
	}

}
