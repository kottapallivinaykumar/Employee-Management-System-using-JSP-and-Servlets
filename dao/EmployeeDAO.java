package com.emp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.emp.dto.Employee;
import com.emp.util.DbConnection;

public class EmployeeDAO {

	public boolean saveEmployee(Employee e) 
	{

		String save="INSERT INTO employee VALUES(?,?,?,?,?,?,?)";


		try(Connection con=DbConnection.getConnect();
				PreparedStatement ps=con.prepareStatement(save);)

		{
			ps.setString(1, e.getEmployeeId());
			ps.setString(2, e.getEmployeeName());
			ps.setString(3, e.getDesignation());
			ps.setDouble(4, e.getSalary());
			ps.setString(5, e.getCompany());
			ps.setString(6, e.getEmail());
			ps.setString(7, e.getPassword());

			int count=ps.executeUpdate();
			if(count>0) {
				return true;
			}
			else 
				return false;




		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		return false;

	}

	public List<Employee> getAllEmployees()
	{
		List<Employee> list =new ArrayList<Employee>();
		String allemp="select * from employee";
		try(Connection con=DbConnection.getConnect();
				PreparedStatement ps=con.prepareStatement(allemp);)

		{
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setEmployeeId(rs.getString(1));
				emp.setEmployeeName(rs.getString(2));
				emp.setDesignation(rs.getString(3));
				emp.setSalary(rs.getDouble(4));
				emp.setCompany(rs.getString(5));
				emp.setEmail(rs.getString(6));
				emp.setPassword(rs.getString(7));
				list.add(emp);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public boolean deleteEmployee(String employeeId) {

		String delete="DELETE from employee where employeeId=?";
		try(Connection con=DbConnection.getConnect();
				PreparedStatement ps=con.prepareStatement(delete);
				)
		{
			ps.setString(1, employeeId);
			int count=ps.executeUpdate();

			if(count>0) {
				return true;
			}


		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;

	}
	
	public Employee getEmployeeById(String employeeId) {
		
		String emp="select * from employee where employeeId=?";
		Employee e=new Employee();
		
		try(Connection con=DbConnection.getConnect();
				PreparedStatement ps=con.prepareStatement(emp);) 
		{
			ps.setString(1, employeeId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				e.setEmployeeId(rs.getString(1));
				e.setEmployeeName(rs.getString(2));
				e.setDesignation(rs.getString(3));
				e.setSalary(rs.getDouble(4));
				e.setCompany(rs.getString(5));
				e.setEmail(rs.getString(6));
				e.setPassword(rs.getString(7));
				
				return e;
			}
			
			
		} 
		catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		
		return null;
		
	}
	
	public boolean updateEmployeeDetails(Employee emp) {
		String update="update employee set employeeName=?,designation=?,salary=?,company=?,email=?,password=? where employeeId=?";
		
		try(Connection con=DbConnection.getConnect();
				PreparedStatement ps=con.prepareStatement(update);)
		{
			
			ps.setString(1, emp.getEmployeeName());
			ps.setString(2, emp.getDesignation());
			ps.setDouble(3, emp.getSalary());
			ps.setString(4, emp.getCompany());
			ps.setString(5, emp.getEmail());
			ps.setString(6, emp.getPassword());
			ps.setString(7, emp.getEmployeeId());
			
			int count=ps.executeUpdate();
			if(count>0) {
				return true;
			}
			
		} 
		catch (SQLException e) {
			
			e.printStackTrace();
		}
		return false;
	}

}
