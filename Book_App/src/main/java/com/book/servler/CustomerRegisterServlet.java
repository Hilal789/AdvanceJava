package com.book.servler;

import java.io.IOException;

import com.book.bean.CustomerBean;
import com.book.dao.CustomerRegisterDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cust-reg")
@SuppressWarnings("serial")
public class CustomerRegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		CustomerBean cb = new CustomerBean();
		cb.setUname(req.getParameter("username"));
		cb.setPass(req.getParameter("password"));
		cb.setFname(req.getParameter("firstName"));
		cb.setLname(req.getParameter("lastName"));
		cb.setMail(req.getParameter("email"));
		cb.setPhone(Long.parseLong(req.getParameter("phone")));
		
		int k = new CustomerRegisterDAO().insert(cb);
		
		if(k>0) {
			req.setAttribute("msg", "Registation done successfully");
			RequestDispatcher rd = req.getRequestDispatcher("CustomerRegisterSuccess.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("msg", "Plese enter valid ");
			RequestDispatcher rd = req.getRequestDispatcher("registerUnsuccess.jsp");
			rd.forward(req, resp);
		}
		
		
	}
}
