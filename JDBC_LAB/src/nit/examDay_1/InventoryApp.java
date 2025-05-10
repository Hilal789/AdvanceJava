package nit.examDay_1;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class InventoryApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Product pro = new Product();
		
		System.out.println("Enter 1 for enter\n 2 for display");
		int inp = sc.nextInt();
		switch(inp) {
		case 1: 
			pro.insertProductTable();
			break;
			
		case 2:
			pro.displayProductsByCategory("gg");
			
			break;
		}
		
//		
//		public static void displayProductsByCategory() {
//			Scanner sc = new Scanner(System.in);
//			try {
//				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA","123");
//				
//				Statement stmt = (Statement) con.createStatement();
//
//				ResultSet rSet = ((java.sql.Statement) stmt).executeQuery("SELECT * FROM Product");
//				System.out.println("Employees Details: -----");
//				System.out.println("");
//				while (rSet.next()) {
//					System.out.println(rSet.getString(1) + "\t\t" + rSet.getString(2) + "\t\t" + rSet.getString(3)
//							+ "\t\t" + rSet.getInt(4)+ "\t\t" + rSet.getDouble(5)+ "\t\t" + rSet.getString(6));
//
//				}
//				
//				
//
//
//				
//			}catch (Exception e) {
//				
//			e.printStackTrace();
//				
//			}
	}

}
