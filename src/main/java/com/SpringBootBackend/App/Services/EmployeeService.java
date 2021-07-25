package com.SpringBootBackend.App.Services;

import java.util.List;

import com.SpringBootBackend.App.Model.Employee;

public interface EmployeeService {
	
	public List<Employee> getAllEmployees();
	public Employee saveEmployee(Employee e);
	public Employee getEmployeeId(Long EmployeeId);
	public Employee UpdateEmployee(Employee updateEmp);
	public String deleteEmployee(Long EmployeeId);
	
	

}
