import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/dis")
public class DisplayServlet implements Servlet {

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
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phNo = req.getParameter("phNo");
		String address = req.getParameter("address");
		String dob = req.getParameter("dob");
		String depertment = req.getParameter("depertment");
		String designation = req.getParameter("designation");
		String salary = req.getParameter("salary");
		String bgroup = req.getParameter("bgroup");
		
		
		PrintWriter writer = res.getWriter();
		res.setContentType("text/html");
		writer.println("<h1 style='color:blue;'>Hello "+name+"</h1>"
				+ "<br><h1>"+email+"</h1>"
				+ "<br><h1>"+ phNo +"</h1>"
				+ "<br><h1>"+email+"</h1>"
				+ "<br><h1>"+address+"</h1>"
				+ "<br><h1>"+dob+"</h1>"
				+ "<br><h1>"+depertment+"</h1>"
				+ "<br><h1>"+designation+"</h1>"
				+ "<br><h1>"+salary+"</h1>"
				+ "<br><h1>"+bgroup+"</h1>"
				
				);
	
		
		
	}

}
