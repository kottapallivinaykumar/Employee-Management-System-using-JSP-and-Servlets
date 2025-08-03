<%@page import="com.emp.dao.EmployeeDAO"%>
<%@page import="com.emp.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/Edit-Form.css">
</head>
<body>
<%
EmployeeDAO dao = new EmployeeDAO(); 
String employeeId = request.getParameter("employeeId");
Employee emp = dao.getEmployeeById(employeeId);
%>
<form action="Edit" method="get">

<label for="Employee Id">Employee Id</label>
<input type="hidden" name="eid" value="<%=emp.getEmployeeId()%>"><br><br>

<label for="Employee Name">Employee Name</label>
<input type="text" name="ename" value="<%=emp.getEmployeeName()%>"><br><br>

<label for="Designation">Designation</label>
<input type="text" name="desg" value="<%= emp.getDesignation()%>"><br><br>

<label for="Salary">Salary</label>
<input type="text" name="salary" value="<%=emp.getSalary() %>"><br><br>

<label for="Company">Company</label>
<input type="text" name="comp" value="<%=emp.getCompany()%>"><br><br>

<label for="Email">Email</label>
<input type="text" name="email" value="<%=emp.getEmail()%>"><br><br>

<label for="Password">Password</label>
<input type="text" name="pass" value="<%=emp.getPassword()%>"><br><br>
<input type="submit" value="Update">
</form>
</body>
</html>