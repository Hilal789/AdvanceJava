package RetrivedDataFrom_Hospital_7_5_25;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class RetrivedData {

	public static void callProcedure(Connection con) {
		Scanner sc = new Scanner(System.in);

		try {
			CallableStatement cs = con.prepareCall("{call  RetrievePatient(?,?,?,?,?,?,?,?)}");
			System.out.println("Enter ID:");
			int id = sc.nextInt();

			cs.setInt(1, id);
			cs.registerOutParameter(2, Types.CHAR);
			cs.registerOutParameter(3, Types.CHAR);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.CHAR);
			cs.registerOutParameter(6, Types.INTEGER);
			cs.registerOutParameter(7, Types.CHAR);
			cs.registerOutParameter(8, Types.DOUBLE);

			cs.execute();

			System.out.println("Id=" + id);
			System.out.println("Name : " + cs.getString(2));
			System.out.println("Patient Disease: "+cs.getString(3));
			System.out.println("House No: "+cs.getInt(4));
			System.out.println("City: "+cs.getString(5));
			System.out.println("Pin Code: "+cs.getInt(6));
			System.out.println("Email:"+cs.getString(7));
			System.out.println("Phone No: "+cs.getLong(8));

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "advjava", "123");

			callProcedure(con);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
