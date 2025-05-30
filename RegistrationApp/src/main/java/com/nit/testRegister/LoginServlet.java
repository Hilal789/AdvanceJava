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
		userBean ub = new LoginDAO().login(request.getParameter("uname"), request.getParameter("password"));
		
		if(ub!=null)
		{
			request.setAttribute("bean", ub);
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			
		}else {
			
			request.getRequestDispatcher("loginUnSuccess.jsp").forward(request, response);
		}
		
	}

}
