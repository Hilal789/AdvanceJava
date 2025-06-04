package com.book.servler;

import java.io.IOException;

import com.book.bean.adminRegisterBean;
import com.book.dao.loginsucessDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin-login")
@SuppressWarnings("serial")
public class loginsuccessServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		loginsucessDAO loginDao = new loginsucessDAO();

		String userName = req.getParameter("adminName");
		String pwd = req.getParameter("adminPassword");

		adminRegisterBean ad = new loginsucessDAO().isValidAdmin(userName, pwd);

		if (ad == null) {
			resp.setContentType("text/html");
			resp.getWriter().println("Log In failed");
			req.getRequestDispatcher("adminLogin.html").include(req, resp);
		} else {
			req.setAttribute("bean", ad);
			req.getRequestDispatcher("loginsuccess.html").forward(req, resp);
		}
	}

}
