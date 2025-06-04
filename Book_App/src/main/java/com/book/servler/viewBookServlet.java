package com.book.servler;

import java.io.IOException;
import java.util.List;

import com.book.bean.addBookBean;
import com.book.dao.viewBookDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/viewAllBook")
@SuppressWarnings("serial")
public class viewBookServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
//		List<addBookBean> list = new ArrayList<>();
		
		List<addBookBean> list = new viewBookDAO().viewAll();
		
		if(list!=null) {
			
			req.setAttribute("list", list);
			
			req.getRequestDispatcher("viewAll.jsp").forward(req, resp);
		}
		else {
			
			req.setAttribute("list", "Book Not Found in database");
			
			req.getRequestDispatcher("BookNotFound.jsp").forward(req, resp);
		}
	}
	
	

}
