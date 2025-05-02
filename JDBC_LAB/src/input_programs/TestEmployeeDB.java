package input_programs;

import java.sql.*;

class Employee {
	String name;// can be initialized by object or constructor
	String id;// can be initialized by object or constructor
	int salary;// can be initialized by object or constructor

	public void addEmployee(String id, String name, int salary) {
		try {
			// create a connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");
			// Prepare a statement for a query to insert records
			PreparedStatement psmt = con.prepareStatement("insert into EmployeeDB values(?,?,?)");
			psmt.setString(1, id);
			psmt.setString(2, name);
			psmt.setInt(3, salary);

			int rowInserted = psmt.executeUpdate();
			if (rowInserted > 0) {
				System.out.println("Record entered succesfully");
			} else {
				System.out.println("Could not insert the record");
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

public class TestEmployeeDB {
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		e1.addEmployee("TYP123", "Raju", 20000);
		e2.addEmployee("NIT6679", "Rancho", 25000);
		e3.addEmployee("HYWL5632", "Banti", 35000);
		/*
		 * We can show the usage of instance variable by creating object and intializing
		 * variables or create object and initialize variables with help of
		 * parameterized constructor and then pass the values of each variables
		 * belonging to individual object to the addEmployee().
		 */
	}
}