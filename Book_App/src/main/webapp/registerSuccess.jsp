<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	.success-msg{
	display:flex; 
	flex-direction: column;
	justify-content: center;
	
	
	}
	p{
	color:green;
	font-size: 50px;
	text-align: center;
	}
</style>
<body>

<%
	String msg = (String) request.getAttribute("msg");
	%>
	<script>
	let val=3;
	setInterval(() => {
		time.innerHTML=val--;
	}, 3000);
	</script>
		<div class="success-msg">
	<p><%=msg %></p>
	
	<span id='time'></span>
	</div>
	
</body>
<script >
	setTimeout(() => {
		
			window.open('http://localhost:8080/Book_App/adminLogin.html','_self');
	}, 2000);
</script>
</html>