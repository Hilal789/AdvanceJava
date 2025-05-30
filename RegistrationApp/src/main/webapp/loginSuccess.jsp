<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.nit.testRegister.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
userBean ub =(userBean)request.getAttribute("bean");


%>
<h1 style="text-align: center;">Login Successfull</h1>
<h1 style="text-align: center;"> Welcome <%=  ub.getUsername()%></h1>
</body>
</html>