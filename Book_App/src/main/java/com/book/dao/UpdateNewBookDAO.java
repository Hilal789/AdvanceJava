//package com.book.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//
//import com.book.bean.addBookBean;
//import com.connection.DBConnection;
//
//public class UpdateNewBookDAO {
//	
//	public addBookBean abbean=null;
//	public addBookBean update(String pid)
//	{		
//		try
//		{
//			Connection con = DBConnection.getCon();
//			PreparedStatement ps = con.prepareStatement("select *from add_books where id=?");
//				ResultSet rs = ps.executeQuery();
//				if(rs.next())
//				{
//					abbean=new addBookBean();
//					//set ???? 
//				}
//			
//			
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//	return abbean;
//	}
//
//}
