package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nit.bean.UserBean;
import com.nit.connection.DBConnection;

public class UserRegisterDAO {

	public int insert(UserBean ub) {
		int k = 0;

		try {

			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("insert into room_pailot values(?,?,?,?,?,?,?)");
			ps.setString(1, ub.getId());
			ps.setString(2, ub.getName());
			ps.setString(3, ub.getAddress());
			ps.setString(4, ub.getEmailid());
			ps.setLong(5, ub.getPhone());
			ps.setString(6, ub.getState());
			ps.setString(7, ub.getCountry());
			
			
			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;

	}
}
