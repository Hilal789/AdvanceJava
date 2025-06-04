package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.book.bean.adminRegisterBean;
import com.connection.DBConnection;

public class adminDAO {

	public int insert(adminRegisterBean ub) {
		int k = 0;
		try {

			Connection con = DBConnection.getCon();
			//System.out.println(con);
			PreparedStatement ps = con.prepareStatement("insert into book_app values(?,?,?,?,?,?)");
			System.out.println(ub);
			ps.setString(1, ub.getName());
			ps.setString(2, ub.getPass());
			ps.setString(3, ub.getFname());
			ps.setString(4, ub.getLname());
			ps.setString(5, ub.getMail());

			ps.setLong(6, ub.getPhone());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
