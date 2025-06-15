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
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return ub;
		
	}

}
