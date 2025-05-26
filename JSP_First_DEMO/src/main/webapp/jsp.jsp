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
String uname = request.getParameter("username");
String password = request.getParameter("password");
String firstname = request.getParameter("firstname");
String lastname = request.getParameter("lastname");
String city = request.getParameter("city");
String state = request.getParameter("state");
String pincode = request.getParameter("pincode");
String email = request.getParameter("email");
long  phoneno = Long.parseLong(request.getParameter("phoneno"));


out.println("User name: "+ uname+"<br>");
out.println("password: "+ password+"<br>");
out.println("User firstname: "+ firstname+"<br>");
out.println("User lastname: "+ lastname+"<br>");
out.println("User city: "+ city+"<br>");
out.println("User state: "+ state+"<br>");
out.println("User pincode: "+ pincode+"<br>");
out.println("User email: "+ email+"<br>");
out.println("User phoneno: "+ phoneno+"<br>");





%>

</body>
</html>