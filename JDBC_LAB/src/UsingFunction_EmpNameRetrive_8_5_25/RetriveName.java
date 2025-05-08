package UsingFunction_EmpNameRetrive_8_5_25;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class RetriveName {

	public static void callFunction(Connection con) {

		try {
			Scanner sc = new Scanner(System.in);
			
		
			CallableStatement cs = con.prepareCall("{call ?:= emp_search(?)}");
			System.out.println("Enter Id: ");
			int id = sc.nextInt();
			cs.setInt(2, id);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.execute();
			System.out.println("Name is : " + cs.getString(1));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "advjava", "123");
				callFunction(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
