package com.nit.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/")
public class HomeServlet extends HttpServlet{
	
	private UserController user = new UserController();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		HttpSession session = req.getSession(false);
		switch(path) {
		case "/UserLoginForm"->{
				req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
		}
		
		case "/UserRegistationForm"->{
			req.getRequestDispatcher("UserRegistration.jsp").forward(req, resp);
		}
		
		case "/userRegistration"->{
			user.registerUser(req, resp);
		}
		
		case "/loginUser"->{
			user.loginUser(req, resp);
		}
		
		case "/logout"->{
			if(session.getAttribute("user") !=null) {
				user.logout(req, resp);
			}else {
				resp.sendRedirect("UserLogin.jsp");
			}
		
		}
		
		case "/userUpdateForm"->{
			if(session.getAttribute("user") !=null) {
				resp.sendRedirect("UserUpdateForm.jsp");
			}else {
				resp.sendRedirect("UserLogin.jsp");
			}
		}
		
		case "/foodForm"->{
			if(session.getAttribute("user") !=null) {
				user.showCategory(req, resp);
			}else {
				resp.sendRedirect("UserLogin.jsp");
			}
				
		}
		
		case "/foodCategory"->{
			if(session.getAttribute("user") !=null) {
				user.showMainCourses(req, resp);
			}else {
				resp.sendRedirect("UserLogin.jsp");
			}
				
		}
		
		case "/Order_food"->{
			if(session.getAttribute("user") !=null) {
				user.orderFoods(req, resp);
			}else {
				resp.sendRedirect("UserLogin.jsp");
			}
		
		}
		
		
	
		
		
		
		
		
		
		}
	}
}
