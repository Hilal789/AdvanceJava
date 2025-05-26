package Exam_JDBC_24_05_25;

import java.sql.SQLException;

import java.sql.*;

public class StudentDetailsFetcher {

	public static void main(String[] args) {
		int studentId = 1;

		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String username = "advjava";
		String password = "123";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			CallableStatement stmt = conn.prepareCall("{ call get_student_details(?, ?, ?, ?, ?, ?) }");

			stmt.setInt(1, studentId);
			stmt.registerOutParameter(2, Types.VARCHAR); 
			stmt.registerOutParameter(3, Types.VARCHAR); 
			stmt.registerOutParameter(4, Types.VARCHAR); 
			stmt.registerOutParameter(5, Types.VARCHAR); 
			stmt.registerOutParameter(6, Types.VARCHAR); 

			stmt.execute();

			String name = stmt.getString(2);
			String street = stmt.getString(3);
			String city = stmt.getString(4);
			String state = stmt.getString(5);
			String zip = stmt.getString(6);

			if (name != null) {
				System.out.println("Student Name: " + name);
				System.out.println("Address: " + street + ", " + city + ", " + state + ", " + zip);
			} else {
				System.out.println("No student found with ID: " + studentId);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
