package com.nit.testRegister;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/log")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		userBean bean =new  LoginDAO().login(uname, password);
		
		if(bean==null) {
			request.setAttribute("msg", "Invalid credential");
			request.getRequestDispatcher("loginUnSuccess.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "Login Successfull..");
			request.setAttribute("bean", bean);
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
		}
		
	}

}
