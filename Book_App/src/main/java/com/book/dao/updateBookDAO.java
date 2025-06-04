package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.book.bean.updateBookBean;
import com.connection.DBConnection;

public class updateBookDAO {

	// Method to update book by ID
	public int updateBook(updateBookBean book) {
		int result = 0;
		try {
			Connection con = DBConnection.getCon(); // Get DB connection

			String sql = "UPDATE add_books SET TITLE = ?, author = ?, TYPE = ?, YEAR = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setString(3, book.getType());
			ps.setInt(4, book.getYear());
			ps.setString(5, book.getId());

			result = ps.executeUpdate(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
