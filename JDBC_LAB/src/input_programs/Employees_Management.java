package input_programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Employees_Management {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA","123")) {

				System.out.println("-------------------------------------------------");

				System.out.println("Choice 1: Fetch witch salary greater than Enter : \n"
						+ "Choice 2: Fetch all the employee details.\n" + "Choice 3: Insert  new employee details\n"
						+ "Choice 4: Exit the program");

				System.out.println("-------------------------------------------------");

				int input = Integer.parseInt(sc.nextLine());

				switch (input) {
				case 1:
					System.out.println("Salary greater than Enter : ");
					int greater = Integer.parseInt(sc.nextLine());
					PreparedStatement ps1 = con.prepareStatement("SELECT * FROM Employees where salary>?");
					ps1.setInt(1, greater);
					ResultSet rs = ps1.executeQuery();
					while (rs.next()) {
						System.out.println(rs.getString(1) + "\t\t" + rs.getString(2) + "\t\t" + rs.getString(3)
								+ "\t\t" + rs.getInt(4));
					}

					break;

				case 2:
					Statement stmt = con.createStatement();

					ResultSet rSet = stmt.executeQuery("SELECT * FROM Employees");
					System.out.println("Employees Details: -----");
					System.out.println("ID\t\tName\t\tDesignation\t\tSalary");
					while (rSet.next()) {
						System.out.println(rSet.getString(1) + "\t\t" + rSet.getString(2) + "\t\t" + rSet.getString(3)
								+ "\t\t" + rSet.getInt(4));

					}

					break;

				case 3:
					PreparedStatement ps = con.prepareStatement("insert into Employees values(?,?,?,?)");

					System.out.println("How many records you need: ");
					int entry = Integer.parseInt(sc.nextLine());
					for (int i = 1; i <= entry; i++) {
						System.out.println("Enter Employee ID:");
						String id = sc.nextLine();

						System.out.println("Enter Employee Name:");
						String name = sc.nextLine();

						System.out.println("Enter Designation: ");
						String designation = sc.nextLine();

						System.out.println("Enter Salary: ");
						int salary = Integer.parseInt(sc.nextLine());

						ps.setString(1, id);
						ps.setString(2, name);
						ps.setString(3, designation);
						ps.setInt(4, salary);
						int records = ps.executeUpdate();
						if (records > 0) {
							System.out.println(records + " Records entered successfully");
						} else {
							System.out.println("Records coulnot be entered into DB");
							System.out.println("Kindly contact the Admin");
						}
					}

					break;

				case 4:
					System.exit(0);
					break;

				default:
					System.out.println("Enter right Choice");
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	}
}
