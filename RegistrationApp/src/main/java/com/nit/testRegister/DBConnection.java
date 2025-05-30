package com.nit.testRegister;

import java.sql.Connection;
import java.sql.DriverManager;

//DataBase connection point
public class DBConnection {
	
	
	private static Connection con = null;
	static String url = DBInfo.url;
	static String password = DBInfo.password;
	static String userName = DBInfo.userName;
	
	private DBConnection(){};

	
	public static Connection getCon() {
		if (con == null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println(url);
				System.out.println(userName);
				System.out.println(password);
				con = DriverManager.getConnection(url, userName, password);
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
}
