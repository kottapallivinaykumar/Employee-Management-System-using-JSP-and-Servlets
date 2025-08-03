package com.emp.controller;

import java.io.IOException;

import com.emp.dao.EmployeeDAO;
import com.emp.dto.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;


@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	EmployeeDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao=new EmployeeDAO();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eid=request.getParameter("employeeId");
		
		Employee employee=dao.getEmployeeById(eid);
		if(employee!=null) {
		request.setAttribute("emp", employee);
		}
		else {
			request.setAttribute("error", "employee not found with ");
		}
		RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}

}
