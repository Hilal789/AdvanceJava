package com.nit.testRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	// create a method to login(userBean ub)... use JDBC login to retrieve the data
	// from db

	public userBean ub;

	public userBean login(String uname, String password) {

		try {
			Connection con = DBConnection.getCon();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement("select * from userdb where username=? and password =? ");
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ub = new userBean();
				ub.setUsername(rs.getString(1));
				ub.setPassword(rs.getString(2));
							
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ub;
	}

}
