package Car_RentalSystem_12_5_25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Car_Rental {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int carId=101;

		String carModel="BMW";

		double carRatePerDay=2000;

		String availabilityStatus="not booked";
		
		
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");
			System.out.println("Enter Car ID: ");
			int id = Integer.parseInt(sc.nextLine());
			
			System.out.println("Enter Car Model: ");
			String carM = sc.nextLine();
			
			System.out.println("Enter car Rate Per Day: ");
			double carRate = Double.parseDouble(sc.nextLine());
			
			System.out.println("Enter Availabity Status: ");
			String availabilabity  = sc.nextLine();
			
			
			
			Statement st = con.createStatement();
			st.addBatch("insert into Car_Info values("+id+",'"+carM+"',"+carRate+",'"+availabilabity+"')");
			
			st.addBatch("update Car_Info set availabilityStatus ='booked' where carModel='"+carM+"' ");

			
			st.addBatch("delete from car_info where carRatePerDay>"+10000+"");
			int[] executeBatch = st.executeBatch();
			for (int i : executeBatch) {
				
				System.out.println("Batch executed");
			}
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
