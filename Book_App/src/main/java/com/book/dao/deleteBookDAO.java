package com.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.book.bean.deleteBookBean;
import com.connection.DBConnection;

public class deleteBookDAO {

    public int removeBook(deleteBookBean deleteBook) {
        int k = 0;

        try {
            Connection con = DBConnection.getCon();
          //  System.out.println(con); // Optional: remove in production
            PreparedStatement ps = con.prepareStatement("DELETE FROM add_books WHERE id = ?");
            
            ps.setString(1, deleteBook.getId());
            k = ps.executeUpdate(); // returns number of rows affected

        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
