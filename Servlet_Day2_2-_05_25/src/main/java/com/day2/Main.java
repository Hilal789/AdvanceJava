package com.day2;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/home")
public class Main implements Servlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String Uid = req.getParameter("uid");
		String Fname = req.getParameter("fname");
		String Lname = req.getParameter("lname");
		String Mail = req.getParameter("mail");
		String Phone = req.getParameter("pno");

		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		writer.println("<h1>User ID : " + Uid + "</h1>");
		writer.println("<h1>User Fname :" + Fname +"</h1>");
		writer.println("<h1>User Lname :" + Lname+"</h1>");
		writer.println("<h1>User Mail : " + Mail+"</h1>");
		writer.println("<h1>User Phone : " + Phone+"</h1>");
		

	}
}
