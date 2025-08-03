package com.emp.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.emp.dao.EmployeeDAO;

import jakarta.servlet.annotation.WebServlet;


@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao=new EmployeeDAO();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		String eid=request.getParameter("employeeId");
		boolean isDelete=dao.deleteEmployee(eid);
		if(isDelete) {
			response.sendRedirect("view");
		}


	}



}
