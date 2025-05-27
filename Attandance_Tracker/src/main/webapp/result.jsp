<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance Tracker</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
</head>
<body>
<div class="d-flex flex-column align-items-center gap-4 w-50 border border-2 m-auto bg-dark">
<h1 class="text-center text-light">Exam Eligibility Result</h1>
<%
	Double per=	(Double)request.getAttribute("per");	

	DecimalFormat df=new DecimalFormat("00.00");
	String percentage=df.format(per);
	if(per>75)
	{
		
%>
<h3 class="text-center text-primary"><%=percentage %> %</h3>
<p class="text-success text-center">Congratulation! You are eligible for the exam<p>
<%
	}
	else
	{
%>
<h3 class="text-center text-primary"><%=percentage %> %</h3>
<p class="text-danger text-center">Sorry ! You are not eligible for the exam<p>
<%
	}
%>
</div>

</body>
</html>