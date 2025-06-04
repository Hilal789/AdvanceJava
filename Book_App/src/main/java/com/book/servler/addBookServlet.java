package com.book.servler;

import java.io.IOException;

import com.book.bean.addBookBean;
import com.book.dao.addBookDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-book")
@SuppressWarnings("serial")
public class addBookServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		addBookBean addbean = new addBookBean();
		
		addbean.setId(req.getParameter("bookId"));
		addbean.setTitle(req.getParameter("title"));
		addbean.setAuthor(req.getParameter("author"));
		addbean.setType(req.getParameter("genre"));
		addbean.setYear(Integer.parseInt(req.getParameter("year")));

		int k = new addBookDAO().insertBook(addbean);

		if (k > 0) {
			req.setAttribute("msg", "Book Added successfully");
			RequestDispatcher rd = req.getRequestDispatcher("bookAddSuccess.jsp");
			rd.forward(req, resp);

		} else {
			req.setAttribute("msg", "Book Not Added ! Enter valid Details ");
			RequestDispatcher rd = req.getRequestDispatcher("bookUnsuccess.jsp");
			rd.forward(req, resp);
		} 
	}

}
