package com.nit.testRegister;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/reg")
public class registerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		userBean ub = new userBean();
		ub.setUsername(req.getParameter("username"));
		ub.setPassword(req.getParameter("password"));
		ub.setFname(req.getParameter("firstname"));
		ub.setLname(req.getParameter("lastname"));
		ub.setAddress(req.getParameter("address"));
		ub.setMail(req.getParameter("email"));
		ub.setPhone(Long.parseLong(req.getParameter("phone")));

		int k = new RegisterDAO().insert(ub);

		if (k > 0) {
			req.setAttribute("msg", "Registation done successfully");
			RequestDispatcher rd = req.getRequestDispatcher("Request.jsp");
			rd.forward(req, resp);

		}

	}

}
