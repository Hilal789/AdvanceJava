package input_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertOperation {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");

			PreparedStatement ps = con.prepareStatement("insert into laptop values(?,?,?,?,?)");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice: 1 for Entry,"
					+ " 2 for display");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
			case 1:
				System.out.println("How many records you need: ");
				int entry = Integer.parseInt(sc.nextLine());
				for (int i = 1; i <= entry; i++) {
					System.out.println("Enter BrandName:");
					String brandName = sc.nextLine();

					System.out.println("Enter Model:");
					String model = sc.nextLine();

					System.out.println("Enter processor: ");
					String processor = sc.nextLine();

					System.out.println("Enter RAM size: ");
					int ramSize = Integer.parseInt(sc.nextLine());

					System.out.println("Enter Price: ");
					int price = Integer.parseInt(sc.nextLine());

					// Passing to DB
					ps.setString(1, brandName);
					ps.setString(2, model);
					ps.setString(3, processor);
					ps.setInt(4, ramSize);
					ps.setInt(5, price);
					int records = ps.executeUpdate();
					if (records > 0) {
						System.out.println(records + " Records entered successfully");
					} else {
						System.out.println("Records coulnot be entered into DB");
						System.out.println("Kindly contact the Admin");
					}
				}
				break;
			case 2:
				ResultSet rSet = ps.executeQuery("select * from laptop");

				System.out.println("Brand Name\tModel\t\tProcessor\t\tRAM Size\t\tPrice");

				while (rSet.next()) {
					System.out.println(rSet.getString(1) + "\t\t" + rSet.getString(2) + "\t\t" + rSet.getString(3)
							+ "\t\t" + rSet.getInt(4) + "\t\t" + rSet.getInt(5));
				}
				break;
			default:
				System.err.println("Invalid choice Enter correct choice.");
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}