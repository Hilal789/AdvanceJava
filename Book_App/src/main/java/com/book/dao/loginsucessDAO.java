package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.book.bean.adminRegisterBean;
import com.connection.DBConnection;

public class loginsucessDAO {

	public adminRegisterBean isValidAdmin(String uname,String pass) {
		adminRegisterBean ab=null;
		int k = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DBConnection.getCon();
		//	System.out.println(con);
			PreparedStatement ps = con.prepareStatement("select* from book_app where NAME=? AND PASSWORD=?");
			ps.setString(1, uname);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				ab=new adminRegisterBean();
				ab.setName(rs.getString(1));
				ab.setPass(rs.getString(2));
				ab.setFname(rs.getString(3));
				ab.setLname(rs.getString(4));
				ab.setMail(rs.getString(5));
				ab.setPhone(rs.getLong(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ab;
	}
}
