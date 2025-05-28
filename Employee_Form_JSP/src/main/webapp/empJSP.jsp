<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Form</title>
</head>
<style>
	table {
		border-collapse: collapse;
		width: 50%;
		margin: 20px auto;
	}
	th, td {
		border: 1px solid #ccc;
		padding: 8px;
		text-align: left;
	}
	th {
		background-color: #f2f2f2;
	}
</style>
</head>
<body>
	<%
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String empAddress = request.getParameter("empAddress");
		String empSalary = request.getParameter("empSalary");
		String empGender = request.getParameter("empGender");
		String empProfile = request.getParameter("empProfile");
		String empHobbies[] = request.getParameterValues("empHobbies");
	%>

	<table>
		<tr>
			<th>Field</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Employee ID</td>
			<td><%= empId %></td>
		</tr>
		<tr>
			<td>Employee Name</td>
			<td><%= empName %></td>
		</tr>
		<tr>
			<td>Employee Address</td>
			<td><%= empAddress %></td>
		</tr>
		<tr>
			<td>Employee Salary</td>
			<td><%= empSalary %></td>
		</tr>
		<tr>
			<td>Employee Gender</td>
			<td><%= empGender %></td>
		</tr>
		<tr>
			<td>Employee Profile</td>
			<td><%= empProfile %></td>
		</tr>
		<tr>
			<td>Employee Hobbies</td>
			<td>
				<%
					if (empHobbies != null) {
						for (int i = 0; i < empHobbies.length; i++) {
							out.print(empHobbies[i]);
							if (i < empHobbies.length - 1) out.print(", ");
						}
					} else {
						out.print("None");
					}
				%>
			</td>
		</tr>
	</table>
	</body>
</html>