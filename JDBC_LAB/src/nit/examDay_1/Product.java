package nit.examDay_1;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Product {

	String productId;
	String productName;
	String category;
	int quantity;
	double price;
	String supplier;

//	public Product(String productId, String productName, String category, int quantity, double price, String supplier) {
//		super();
//		this.productId = productId;
//		this.productName = productName;
//		this.category = category;
//		this.quantity = quantity;
//		this.price = price;
//		this.supplier = supplier;
//	}

	public static void insertProductTable() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");
			PreparedStatement ps = con.prepareStatement("insert into Product values(?,?,?,?,?,?)");

			System.out.println("Enter Id:");
			String id = sc.nextLine();

			System.out.println("Enter Name: ");
			String name = sc.nextLine();

			System.out.println("Enter Category: ");
			String category = sc.nextLine();

			System.out.println("Enter Quantity:  ");
			int que = Integer.parseInt(sc.nextLine());

			System.out.println("Enter price:");
			// double price = sc.nextDouble();
			double price = Double.parseDouble(sc.nextLine());

			System.out.println("Enter Supplier name: ");
			String supplier = sc.nextLine();

			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, category);
			ps.setInt(4, que);
			ps.setDouble(5, price);
			ps.setString(6, supplier);

			int records = ps.executeUpdate();

			if (records > 0) {
				System.out.println("Product record inserted successfully");
			} else {
				System.out.println("Error");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void displayProductsByCategory(String category) {
		Scanner sc = new Scanner(System.in);
		try {
			
		
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");
			System.out.println("Enter catagory:");
			String catagory = sc.nextLine();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Product where CAREGORY = ?");
			ps.setString(1, catagory);
			ResultSet rSet = ps.executeQuery();
			System.out.println(" -----");
			System.out.println("");
			while (rSet.next()) {
				System.out.println(rSet.getString(1) + "\t\t" + rSet.getString(2) + "\t\t" + rSet.getString(3) + "\t\t"
						+ rSet.getInt(4) + "\t\t" + rSet.getDouble(5) + "\t\t" + rSet.getString(6));

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}