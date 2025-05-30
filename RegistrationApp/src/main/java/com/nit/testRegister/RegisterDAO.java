package com.nit.testRegister;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

	public  int insert(userBean ub) {
		int k = 0;
		try {

			Connection con = DBConnection.getCon();
			System.out.println(con);
			PreparedStatement ps = con.prepareStatement("insert into userdb values (?,?,?,?,?,?,?)");
			System.out.println(ub);
			ps.setString(1, ub.getUsername());
			ps.setString(2, ub.getPassword());
			ps.setString(3, ub.getFname());
			ps.setString(4, ub.getLname());
			ps.setString(5, ub.getAddress());
			ps.setString(6, ub.getMail());
			ps.setLong(7, ub.getPhone());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
