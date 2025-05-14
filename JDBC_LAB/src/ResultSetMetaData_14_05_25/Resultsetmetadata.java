package ResultSetMetaData_14_05_25;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class Resultsetmetadata {

	public static void main(String[] args) {

		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ADVJAVA", "123");

			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("select * from emp");

			ResultSetMetaData md = rs.getMetaData();
			int columnCount = md.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				System.out.println(md.getColumnName(i) + " " + md.getColumnLabel(i) + " " + md.getColumnType(i) + " "
						+ md.getColumnDisplaySize(i) + "" + md.isNullable(i) + "" + md.isAutoIncrement(i));

			}



		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
