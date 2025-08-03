package com.emp.controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;

import com.emp.dao.EmployeeDAO;
import com.emp.dto.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;


@WebServlet("/view")
public class ViewEmployeeServlet extends HttpServlet {
	EmployeeDAO dao=new EmployeeDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<Employee> emplist=dao.getAllEmployees();
		request.setAttribute("allemployees", emplist);

		RequestDispatcher rd=request.getRequestDispatcher("EmployeeList.jsp");
		rd.forward(request, response);


	}

}
