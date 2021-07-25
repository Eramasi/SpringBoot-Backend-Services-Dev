package com.SpringBootBackend.App.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.SpringBootBackend.App.Exception.ResourceNotFoundException;
import com.SpringBootBackend.App.Model.Employee;
import com.SpringBootBackend.App.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository emprepo;

	@Override
	public List<Employee> getAllEmployees() {
		
		return emprepo.findAll();
	}

	@Override
	public Employee saveEmployee(Employee e) {
		
		return emprepo.save(e);
		
		
	}

	@Override
	public Employee getEmployeeId(Long EmployeeId)
	{
		
	  return emprepo.findById(EmployeeId).orElseThrow(() -> new ResourceNotFoundException("Employee not Exist with Id :" + EmployeeId));
		
	
	}

	@Override
	public Employee UpdateEmployee(Employee updateEmp) {
		
		Employee ExistingEmp = emprepo.findById(updateEmp.getId()).orElse(null);
		ExistingEmp.setFirstName(updateEmp.getFirstName());
		ExistingEmp.setLastName(updateEmp.getLastName());
		ExistingEmp.setEmailId(updateEmp.getEmailId());
		
		return emprepo.save(ExistingEmp);
		
		
		
	}

	@Override
	public String deleteEmployee(Long EmployeeId) {
		
		emprepo.deleteById(EmployeeId);
		return "Employee Deleted Successfully : " + EmployeeId;
	}

}
