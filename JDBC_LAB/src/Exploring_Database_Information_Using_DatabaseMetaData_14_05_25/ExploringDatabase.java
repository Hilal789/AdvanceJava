package Exploring_Database_Information_Using_DatabaseMetaData_14_05_25;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ExploringDatabase {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");
			// System.out.println(con);
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from emp");

			DatabaseMetaData dt = con.getMetaData();
			System.out.println(dt.getDatabaseProductName() + " " + dt.getDatabaseProductVersion() + " "
					+ dt.getUserName() + " " + dt.supportsBatchUpdates() + "\n " + dt.supportsStoredProcedures() + "\n"
					+ dt.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE) + "\n"
					+ dt.supportsCatalogsInTableDefinitions() + ""
					+ dt.getTables(null, null, "%", new String[] { "TABLE" }));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
