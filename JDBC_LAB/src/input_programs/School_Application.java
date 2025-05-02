package input_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class School_Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA ",
					"123 ")) {
				System.out.println("-----------------------------------------------");

				System.out.println("Enter 1 for Enter Student details: ");
				System.out.println("Enter 2 for Showing All Student: ");
				System.out.println("Enter 3 for Search Studetn: ");
				System.out.println("Enter 4 for Delect Studetn:  ");

				System.out.println("-----------------------------------------------");

				int input = Integer.parseInt(sc.nextLine());

				switch (input) {

				case 1:
					System.out.println("Enter how many student details you Enter: ");
					int n = Integer.parseInt(sc.nextLine());
					PreparedStatement ps1 = con.prepareStatement("insert into SCHOOL_APP values(?,?,?)");
					for (int i = 1; i <= n; i++) {
						System.out.println("Enter Class: ");
						int Class = Integer.parseInt(sc.nextLine());

						System.out.println("Enter Roll No: ");
						int RollNo = Integer.parseInt(sc.nextLine());

						System.out.println("Enter Student Name: ");
						String SName = sc.nextLine();

						ps1.setInt(1, Class);
						ps1.setInt(2, RollNo);
						ps1.setString(3, SName);

						int records = ps1.executeUpdate();

						if (records > 0) {
							System.out.println(records + " Records entered successfully");
						} else {
							System.out.println("Records coulnot be entered into DB");
							System.out.println("Kindly contact the Admin");
						}

					}
					break;

				case 2:

					Statement stmt = con.createStatement();

					ResultSet rSet = stmt.executeQuery("SELECT * FROM SCHOOL_APP");
					System.out.println("Studetn  Details: -----");
					System.out.println("CLASS\t\tRoll NO\t\tName");
					while (rSet.next()) {
						System.out.println(rSet.getInt(1) + "\t\t" + rSet.getInt(2) + "\t\t" + rSet.getString(3));

					}

					break;

				case 3:
					System.out.println("Search Student Name: ");
					String Sname = sc.nextLine();

					PreparedStatement ps3 = con.prepareStatement("select * from school_app where name = ?");
					ps3.setString(1, Sname);
					ResultSet rSet3 = ps3.executeQuery();
					System.out.println("Studetn  Details: -----");
					System.out.println("CLASS\t\tRoll NO\t\tName");

					while (rSet3.next()) {
						System.out.println(rSet3.getInt(1) + "\t\t" + rSet3.getInt(2) + "\t\t" + rSet3.getString(3));

					}
					break;
					
				case 4:
					System.out.println("Enter Delete Studetn Name: ");
					String Sname4 = sc.nextLine();
					
					PreparedStatement ps4 = con.prepareStatement("DELETE FROM school_app WHERE Name= ?;");
					
					ResultSet rSet4 = ps4.executeQuery();
					System.out.println("Studetn  Details: -----");
					System.out.println("CLASS\t\tRoll NO\t\tName");

					while (rSet4.next()) {
						System.out.println(rSet4.getInt(1) + "\t\t" + rSet4.getInt(2) + "\t\t" + rSet4.getString(3));

					}
					break;
					
					
					
				}

			} catch (Exception e) {
				e.getStackTrace();
			}
		}

	}

}
