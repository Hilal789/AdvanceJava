package com.book.servler;


import java.io.IOException;
import java.util.List;

import com.book.bean.CustomerBookBean;
import com.book.bean.CustomerViewBookBean;
import com.book.dao.CustomerViewBookDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
@WebServlet("/vewAll")
public class viewBookCustomerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


		List<CustomerViewBookBean> list = new CustomerViewBookDAO().viewAll();
		if (list != null) {

			req.setAttribute("list", list);

			req.getRequestDispatcher("CustomerViewAll.jsp").forward(req, resp);
		} else {

			req.setAttribute("list", "Book Not Found in database");

			req.getRequestDispatcher("BookNotFound.jsp").forward(req, resp);
		}
	}

}
