package com.book.servler;

import java.io.IOException;

import com.book.bean.adminRegisterBean;
import com.book.dao.adminDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/adminRegisterReq")
@SuppressWarnings("serial")
public class adminRegisterServler extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		adminRegisterBean ub = new adminRegisterBean();
		ub.setName(req.getParameter("adminName"));
		ub.setPass(req.getParameter("adminPassword"));
		ub.setFname(req.getParameter("firstName"));
		ub.setLname(req.getParameter("lastName"));
		ub.setMail(req.getParameter("email"));
		ub.setPhone(Long.parseLong(req.getParameter("phone")));

		int k = new adminDAO().insert(ub);

		if (k > 0) {
			req.setAttribute("msg", "Registation done successfully");
			RequestDispatcher rd = req.getRequestDispatcher("registerSuccess.jsp");
			rd.forward(req, resp);

		}
		else {
			req.setAttribute("msg", "Plese enter valid ");
			RequestDispatcher rd = req.getRequestDispatcher("registerUnsuccess.jsp");
			rd.forward(req, resp);
		}

	}

}
