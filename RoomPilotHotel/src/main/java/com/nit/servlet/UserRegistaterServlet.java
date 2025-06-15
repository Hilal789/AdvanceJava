package com.nit.servlet;

import java.io.IOException;

import com.nit.bean.UserBean;
import com.nit.dao.UserRegisterDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


//@WebServlet("/userRegistration")
@SuppressWarnings("serial")
public class UserRegistaterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserBean ub = new UserBean();
		ub.setId(req.getParameter("id"));
		ub.setName(req.getParameter("name"));
		ub.setAddress(req.getParameter("address"));
		ub.setEmailid(req.getParameter("mailid"));
		ub.setPhone(Long.parseLong(req.getParameter("phone")));
		ub.setState(req.getParameter("state"));
		ub.setCountry(req.getParameter("country"));
		
			
		int k = new UserRegisterDAO().insert(ub);
		
		if(k>0) 
		{
			req.setAttribute("msg", "User Registation done successfully");
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistationSuccess.jsp");
			rd.forward(req, resp);
		}else {
			req.setAttribute("msg", "Registation not done !!!");
			RequestDispatcher rd = req.getRequestDispatcher("UserRegistationUnSuccess.jsp");
			rd.forward(req, resp);
		}
	}
	
	
	
	

}
