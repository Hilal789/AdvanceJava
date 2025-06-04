package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

import com.book.bean.addBookBean;
import com.connection.DBConnection;

public class addBookDAO {

	public int insertBook(addBookBean addbook) {
		int k = 0;
		try {

			Connection con = DBConnection.getCon();
//			System.out.println(con);
			PreparedStatement ps = con.prepareStatement("insert into add_books values(?,?,?,?,?)");
			//System.out.println(addbook);
			ps.setString(1, addbook.getId());
			ps.setString(2, addbook.getTitle());
			ps.setString(3, addbook.getAuthor());
			ps.setString(4, addbook.getType());
			ps.setInt(5, addbook.getYear());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
