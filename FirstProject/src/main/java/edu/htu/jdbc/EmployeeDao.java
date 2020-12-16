package edu.htu.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.htu.bean.Employee;

public class EmployeeDao extends GenericDao {

	public Employee findEmployee(int id) throws SQLException {
		PreparedStatement ps = getPreparedStatement("SELECT * FROM hr_employees WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Employee employee = new Employee();
		while (rs.next()) {
			employee = populatEmployee(rs);
		}
		return employee;
	}

	public ArrayList<Employee> lstEmployees() throws SQLException {
		PreparedStatement ps = getPreparedStatement("SELECT * FROM hr_employees");
		ResultSet rs = ps.executeQuery();
		ArrayList<Employee> lstEmployees = new ArrayList<>();
		while (rs.next()) {
			lstEmployees.add(populatEmployee(rs));
		}
		return lstEmployees;
	}

	private Employee populatEmployee(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("id"));
		employee.setName(rs.getString("name"));
		employee.setSalary(rs.getDouble("salary"));
		return employee;
	}
	
	public void isnertEmployee(Employee employee) {
		
	}
	
	
}