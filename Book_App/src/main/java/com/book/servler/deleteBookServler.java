package com.book.servler;

import java.io.IOException;

import com.book.bean.deleteBookBean;
import com.book.dao.deleteBookDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete-book")
@SuppressWarnings("serial")
public class deleteBookServler extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		deleteBookBean dbook = new deleteBookBean();

		dbook.setId(req.getParameter("bookId"));

		int k = new deleteBookDAO().removeBook(dbook);

		if (k > 0) {
			req.setAttribute("msg", "Delete Book successfully");
			RequestDispatcher rd = req.getRequestDispatcher("deleteSuccess.jsp");
			rd.forward(req, resp);

		} else {
			req.setAttribute("msg", "Book Not Added ! Enter valid Details ");
			RequestDispatcher rd = req.getRequestDispatcher("deleteUnSuccess.jsp");
			rd.forward(req, resp);
		}

	}

}
