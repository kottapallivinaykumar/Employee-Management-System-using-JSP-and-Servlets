<%@page import="com.emp.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/EmployeeList.css">
</head>
<body>
<c:import url="header.jsp"></c:import>

	<table border="1">

		<thead>
			<tr>
				<th>employeeId</th>
				<th>employeeName</th>
				<th>designation</th>
				<th>salary</th>
				<th>company</th>
				<th>email</th>
				<th>password</th>
				<th>Action</th>
				
			</tr>
		</thead>	
		<% 
    List<Employee> list= (List) request.getAttribute("allemployees");
        for (Employee emp : list) {
%>
        <tbody>
            <tr>
                <td> <%= emp.getEmployeeId() %></td>
                <td><%= emp.getEmployeeName() %></td>
                <td><%= emp.getDesignation() %></td>
                <td><%= emp.getSalary() %></td>
                <td><%= emp.getCompany() %></td>
                <td><%= emp.getEmail() %></td>
                <td><%= emp.getPassword() %></td>
               <td><a href="Edit-Form.jsp?employeeId=<%=emp.getEmployeeId()%>">Edit</a> 
                  <a href="Delete?employeeId=<%=emp.getEmployeeId()%>">Delete</a> </td>
            </tr> 
            </tbody>
<%
        } 
%>	
	</table>

</body>
</html>