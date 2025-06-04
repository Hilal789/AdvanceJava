package com.book.servler;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.book.bean.updateBookBean;
import com.book.dao.updateBookDAO;

@WebServlet("/update-book")
public class updateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		updateBookBean upBook = new updateBookBean();

		upBook.setId(req.getParameter("bookId"));
		upBook.setTitle(req.getParameter("title"));
		upBook.setAuthor(req.getParameter("author"));
		upBook.setType(req.getParameter("genre"));
		upBook.setYear(Integer.parseInt(req.getParameter("year")));

		int k = new updateBookDAO().updateBook(upBook);

		if (k > 0) {
			req.setAttribute("msg", "Update Successfull");
			RequestDispatcher rd = req.getRequestDispatcher("updateBookSuccess.jsp");
			rd.forward(req, resp);

		} else {
			req.setAttribute("msg", "Plese enter valid ");
			RequestDispatcher rd = req.getRequestDispatcher("updateBookUnSuccess.jsp");
			rd.forward(req, resp);
		}
	}
}
