
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	long num1 = Long.parseLong(request.getParameter("num1"));
	long num2 = Long.parseLong(request.getParameter("num2"));
	
	String calculate = request.getParameter("calculate");
	
	if(calculate.equals("addition")){
		out.println("<h2>"+(num1+num2)+"<h2>");
	}else if(calculate.equals("sub")){
		out.println(num1-num2);
		
	}else if(calculate.equals("multi")){
		out.println(num1*num2);
		
	}else if(calculate.equals("divi")){
		out.println(num1/num2);
		
	}else if(calculate.equals("per")){
		out.println(num1%num2);
		
	}
	%>
	
	

</body>
</html>