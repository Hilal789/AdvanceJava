package register.com.hilal;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/login")

public class Login implements Servlet{

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
		

		PrintWriter out = res.getWriter();

		String email = req.getParameter("email");
		String password  = req.getParameter("password");

		out.println("<html><body>");
		out.println("<h2>Login Details</h2>");
		out.println("<p><strong>Email:</strong> " + email + "</p>");
		out.println("<p><strong>Password:</strong> " + password + "</p>");
		
		out.println("</body></html>");

	}

}
