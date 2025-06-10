package com.book.servler;

import java.io.IOException;

import com.book.bean.CustomerBean;
import com.book.dao.CustomerLoginSucessDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/cust-login")
@SuppressWarnings("serial")
public class CustomerLoginSuccessServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CustomerLoginSucessDao loginDao = new CustomerLoginSucessDao();

		String userName = req.getParameter("custname");
		String pwd = req.getParameter("custpass");

		CustomerBean ad =new CustomerLoginSucessDao().isValidAdmin(userName, pwd);
		//List<BookBean> list=new CustomerLoginSucessDao().view();
		if (ad == null) {
			resp.setContentType("text/html");
			resp.getWriter().println("Log In failed");
			req.getRequestDispatcher("CustomerLogin.html").include(req, resp);
		} else {
			//req.setAttribute("bean", ad);
			req.getRequestDispatcher("vewAll").forward(req, resp);
		}
	}

}
