package com.javabean.lab;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/emp_info")
public class EmployeeServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EmployeeDetails emp = new EmployeeDetails();
		
		emp.setEmpId(Integer.parseInt( req.getParameter("eid")));
		emp.setName(req.getParameter("name"));
		emp.setDepartment(req.getParameter("dep"));
		emp.setDesignation(req.getParameter("design"));
		emp.setSalary(Double.parseDouble(req.getParameter("salary")));
		emp.setEmail(req.getParameter("email"));
		emp.setPhone(Long.parseLong(req.getParameter("phone")));
		req.setAttribute("em", emp);
		RequestDispatcher dispatcher= req.getRequestDispatcher("empJSP.jsp");
		dispatcher.forward(req, resp);
		
	}
	

}
