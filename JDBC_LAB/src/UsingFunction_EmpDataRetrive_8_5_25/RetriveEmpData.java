package UsingFunction_EmpDataRetrive_8_5_25;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class RetriveEmpData {

	public static void callFunction(Connection con) {

		try {
			CallableStatement cs = con.prepareCall("{call ?:= get_total_emp()}");
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			System.out.println("Total Employees: " + cs.getInt(1));

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
