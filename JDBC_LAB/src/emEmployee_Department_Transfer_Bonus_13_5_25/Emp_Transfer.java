package emEmployee_Department_Transfer_Bonus_13_5_25;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Emp_Transfer {
	static Connection con;
	static Scanner sc = new Scanner(System.in);

	public static void getDetails(int id) throws SQLException {

		PreparedStatement statement = con.prepareStatement("select * from emp_table where empid=?");
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			System.out.println("====================================================");
			System.out.println("Id =" + rs.getInt(1));
			System.out.println("Name =" + rs.getString(2));
			System.out.println("Dept =" + rs.getString(3));
			System.out.println("Bonus =" + rs.getDouble(4));
			System.out.println("====================================================");
		}
	}

	public static void addBonus(int id, double amt) throws SQLException {
		con.setAutoCommit(false);

		Statement st = con.createStatement();
		st.addBatch("update emp_table set bonus= bonus+" + amt + " where EMPid=" + id);
		st.executeBatch();

		PreparedStatement ps1 = con.prepareStatement("select * from emp_table where empid=?");
		ps1.setInt(1, id);
		ResultSet rs = ps1.executeQuery();

		while (rs.next()) {
			if (rs.getDouble(4) > 4000) {
				System.out.println("Sorry bouns is getting more that 4000");
				con.rollback();
			} else {
				System.out.println("Bouns is added");
				con.commit();
			}
		}
	}

	public static void addemp() throws SQLException {
		Statement st = con.createStatement();
		System.out.println("Enter Employee ID:");
		int id = Integer.parseInt(sc.nextLine());

		System.out.println("Enter Employee Name: ");
		String Name = sc.nextLine();

		System.out.println("Enter Employee Department:");
		String department = sc.nextLine();

		System.out.println("Enter Bonus: ");
		double bonus = Double.parseDouble(sc.nextLine());

		double addBon = 0;
		st.addBatch("insert into emp_table values(" + id + ",'" + Name + "','" + department + "'," + bonus + ")");

		int[] executeBatch = st.executeBatch();
		for (int i : executeBatch) {

			System.out.println("Batch executed");
		}
	}

	public static void main(String[] args) throws SQLException {

		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");
			while (true) {
				System.out.println("press 1 for add bonus");
				System.out.println("press 2 for add emp");
				System.out.println("press 3 for view emp based on id");
				int choice = Integer.parseInt(sc.nextLine());

				if (choice == 1) {
					System.out.println("Enter id");
					int id = Integer.parseInt(sc.nextLine());
					System.out.println("Enter bonus");
					double amt = Double.parseDouble(sc.nextLine());
					addBonus(id, amt);
				} else if (choice == 2) {

					addemp();
				} else if (choice == 3) {
					System.out.println("Enter Id: ");
					int id = Integer.parseInt(sc.nextLine());
					getDetails(id);
				} else {
					System.exit(0);
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
