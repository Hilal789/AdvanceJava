package Product_Discount_12_5_25_BatchProcessing;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class ProductCampaign {

	public static void ProductDiscountCampaign() {
		Scanner sc = new Scanner(System.in);
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");
			System.out.println("Enter Product ID:");
			int id = Integer.parseInt(sc.nextLine());

			System.out.println("Enter Product Name: ");
			String ProName = sc.nextLine();

			System.out.println("Enter Product Price: ");
			double ProPrice = Double.parseDouble(sc.nextLine());

			System.out.println("Enter Discount Percent: ");
			double ProPercent = Double.parseDouble(sc.nextLine());

			Statement st = con.createStatement();
			st.addBatch("insert into product_info values (" + id + ",'" + ProName + "'," + ProPrice + "," + ProPercent
					+ ")");
			
			double newPrice =ProPrice- ( ProPrice * ProPercent )/100;
			st.addBatch("update  product_info  set PRODUCTPRICE = "+newPrice+"");

			
			st.addBatch("delete from product_info where PRODUCTPRICE<"+100+"");

			
			
			
			int[] executeBatch = st.executeBatch();
			for (int i : executeBatch) {

				System.out.println(i);
				System.out.println("Batch executed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ProductDiscountCampaign();

	}

}
