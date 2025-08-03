package com.emp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.emp.dao.EmployeeDAO;
import com.emp.dto.Employee;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

	private EmployeeDAO dao;

	@Override
	public void init() throws ServletException {
		dao=new EmployeeDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String myeid=request.getParameter("eid");
		String myname=request.getParameter("ename");
		String mydesignation=request.getParameter("desg");
		double mysalary=Double.parseDouble(request.getParameter("salary"));
		String mycompany=request.getParameter("comp");
		String myemail=request.getParameter("email");
		String mypass=request.getParameter("pass");
		Employee emp=new Employee(myeid, myname, mydesignation, mysalary, mycompany, myemail, mypass);
		boolean isSaved=dao.saveEmployee(emp);
		if(isSaved) {		
		out.println("data saved");

		}
		else {
			out.println("error");
		}
	}

}
