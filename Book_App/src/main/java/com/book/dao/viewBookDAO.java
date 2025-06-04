package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.book.bean.addBookBean;
import com.connection.DBConnection;

public class viewBookDAO {

	List<addBookBean> list = null;

	public List<addBookBean> viewAll() {
//		int k = 0;

		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from add_books");

			ResultSet rs = ps.executeQuery();

			list = new ArrayList<>();
			while (rs.next()) {

				addBookBean bb = new addBookBean();
				bb.setId(rs.getString(1));
				bb.setTitle(rs.getString(2));
				bb.setAuthor(rs.getString(3));
				bb.setType(rs.getString(4));
				bb.setYear(rs.getInt(5));

				list.add(bb);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
