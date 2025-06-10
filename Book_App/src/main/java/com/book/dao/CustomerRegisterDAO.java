package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.book.bean.CustomerBean;
import com.connection.DBConnection;

public class CustomerRegisterDAO {
	
	public int insert(CustomerBean cb) {
		int k=0;
		
		try {
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("insert into customer_db values(?,?,?,?,?,?)");
			ps.setString(1, cb.getUname());
			ps.setString(2, cb.getPass());
			ps.setString(3, cb.getFname());
			ps.setString(4, cb.getLname());
			ps.setString(5, cb.getMail());
			ps.setLong(6, cb.getPhone());
			
			k = ps.executeUpdate();
		} catch (Exception e) {

		e.printStackTrace();
		}
		
		
		return k;
		
	}

}
