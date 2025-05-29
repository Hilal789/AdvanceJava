<%@page import="com.javabean.lab.EmployeeDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Info</title>
<style>
table {
	display: flex;
	justify-content: center;
	align-items: center;
	border-collapse: collapse;
}

th, td {
	border: 1px solid black;
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}
</style>
</head>
<body>
	<%
	EmployeeDetails emp = (EmployeeDetails) request.getAttribute("em");
	%>
	<table>
		<tr>
			<th>Employee ID</th>
			<th>Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th>Salary</th>
			<th>Email</th>
			<th>Phone</th>
		</tr>
		<tr>
			<% if (emp != null) { %>
				<td><%= emp.getEmpId() %></td>
				<td><%= emp.getName() %></td>
				<td><%= emp.getDepartment() %></td>
				<td><%= emp.getDesignation() %></td>
				<td><%= emp.getSalary() %></td>
				<td><%= emp.getEmail() %></td>
				<td><%= emp.getPhone() %></td>
			<% } else { %>
				<td colspan="7">No Employee Data Available</td>
			<% } %>
		</tr>
	</table>
</body>
</html>