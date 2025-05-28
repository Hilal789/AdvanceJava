package studentAttandenct;

import java.io.IOException;
import java.text.DecimalFormat;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/attendance")
public class attandanceTrack  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		
//		RequestDispatcher rq = req.getRequestDispatcher("StudentInfo.jsp");
//		rq.forward(req, res);
		
		
		double available =Double.parseDouble(req.getParameter("available"));//500
		
		double total = Double.parseDouble(req.getParameter("total"));//300
		
		double percentage =	(available/total)*100;
		
//		DecimalFormat df=new DecimalFormat("00.00");
//		String per=df.format(percentage);
//		System.out.println(per);
		req.setAttribute("per", percentage);
		
		
			RequestDispatcher rd = req.getRequestDispatcher("result.jsp");
			rd.forward(req, res);
	
		
	}

}
