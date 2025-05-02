package emp.info_2_5_25;

import java.sql.Connection;
import java.sql.DriverManager;

public interface DB {
	public static final String DBURL="jdbc:oracle:thin:@localhost:1521:orcl";
	public static final String PWD="123";
	public static final String USER="ADVJAVA";
	public static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	public static Connection getCon()
	{
		Connection con=null;
		try
		{
			con=DriverManager.getConnection(DBURL,USER,PWD);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
