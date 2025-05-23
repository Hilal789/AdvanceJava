package register.com.hilal;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/reg")

public class RegistationForm implements Servlet {

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
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String phNo = req.getParameter("phNo");
		
		String  gender= req.getParameter("gender");
		String [] skills = req.getParameterValues("skills");
		String country = req.getParameter("country");
		String address = req.getParameter("address");

		out.println("<html><body>");
		out.println("<h2>Registration Details</h2>");
		out.println("<p><strong>Name:</strong> " + name + "</p>");
		out.println("<p><strong>Email:</strong> " + email + "</p>");
		out.println("<p><strong>Email:</strong> " + password + "</p>");
		out.println("<p><strong>Email:</strong> " + phNo + "</p>");
		
		out.println("<p><strong>Gender:</strong> " + gender + "</p>");
		
		
		out.println("<p><strong>Skills:</strong></p>");
		out.println("<ul>");
		if (skills != null) {
			for (String skill : skills) {
				out.println("<li>" + skill + "</li>");
			}
		} else {
			out.println("<li>No Interests selected</li>");
		}
		out.println("</ul>");
		
		out.println("<p><strong>Country:</strong>"+country+"</p>");
		out.println("<p><strong>Address:</strong>"+address+"</p>");

		out.println("</body></html>");
	}

}
