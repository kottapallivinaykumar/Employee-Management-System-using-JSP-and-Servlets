<%@page import="com.emp.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Home</title>
<link rel="stylesheet" href="css/home.css">
</head>
<body>


<img width="50px" alt="Employee" src="image/employeelogo.jpg">
<h1>Welcome to Employee Management</h1>
<%@ include file="header.jsp" %>
	<form action="search">
		<input type="text" name="employeeId" placeholder="Enter Employee ID">
		<input type="submit" value="Search Employee">
	</form>

	<div>
		<%
			Employee employee = (Employee) request.getAttribute("emp");
			if (employee != null) {
		%>
		<table border="1">
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>Name</th>
					<th>Designation</th>
					<th>Salary</th>
					<th>Company</th>
					<th>Email</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%= employee.getEmployeeId() %></td>
					<td><%= employee.getEmployeeName() %></td>
					<td><%= employee.getDesignation() %></td>
					<td><%= employee.getSalary() %></td>
					<td><%= employee.getCompany() %></td>
					<td><%= employee.getEmail() %></td>
					<td><%= employee.getPassword() %></td>
				</tr>
			</tbody>
		</table>
		<%
			}
			String error = (String) request.getAttribute("error");
			if (error != null) {
		%>
		<h3 style="color: red">Employee not found</h3>
		<% } %>
	</div>

</body>
</html>
