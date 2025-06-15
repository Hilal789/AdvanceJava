package com.nit.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		
		switch(path) {
		case "/UserLoginForm"->{
			req.getRequestDispatcher("UserLogin.jsp").forward(req, resp);
		}
		
		case "/UserRegistationForm"->{
			req.getRequestDispatcher("UserRegistration.jsp").forward(req, resp);
		}
		
		case "/loginUser"->{
			user.loginUser(req, resp);
		}
		
		case "/foodForm"->{
			user.showCategory(req, resp);
		}
		
		case "/foodCategory"->{
				user.showMainCourses(req, resp);
		}
		
		case "/Order_food"->{
			user.orderFoods(req, resp);
		}
		
		}
	}
}
