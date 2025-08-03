package com.emp.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;

import com.emp.dao.EmployeeDAO;
import com.emp.dto.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Edit")
public class EditServlet extends HttpServlet{
	private EmployeeDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new EmployeeDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String myeid = request.getParameter("eid");
        String myname = request.getParameter("ename");
        String mydesignation = request.getParameter("desg");
        double mysalary = Double.parseDouble(request.getParameter("salary"));
        String mycompany = request.getParameter("comp");
        String myemail = request.getParameter("email");
        String mypass = request.getParameter("pass");

        Employee emp = new Employee(myeid, myname, mydesignation, mysalary, mycompany, myemail, mypass);

        boolean isUpdated = dao.updateEmployeeDetails(emp);

        if (isUpdated) {
           RequestDispatcher rd=request.getRequestDispatcher("view");
           rd.forward(request, response);
            
        }
    }

}


