package com.nit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nit.bean.UserBean;
import com.nit.connection.DBConnection;

public class UserLoginDAO {
	
	public UserBean isValidUser(String id, String name) {
		
		UserBean ub = null;
		int k=0;
		
		try {
			
			Connection con = DBConnection.getCon();
			
			PreparedStatement ps = con.prepareStatement("select* from room_pailot where id=? AND name=?");
			
			ps.setString(1, id);
			ps.setString(2, name);
			
			ResultSet rs = ps.executeQuery();

			
			if(rs.next())
			{
				ub=new UserBean();
				ub.setId(rs.getString(1));
				ub.setName(rs.getString(2));
				ub.setAddress(rs.getString(3));
				ub.setEmailid(rs.getString(4));
				ub.setPhone(rs.getLong(5));
				ub.setState(rs.getString(6));
				ub.setCountry(rs.getString(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ub;
		
	}
	
	
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
