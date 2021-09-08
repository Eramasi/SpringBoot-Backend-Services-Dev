package com.SpringBootBackend.App.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootBackend.App.Model.Employee;
import com.SpringBootBackend.App.Services.EmployeeService;

@RestController
public class EmployeeController {
	
	//Working fine
	
	@Autowired
	private EmployeeService empservice;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		
		return empservice.saveEmployee(employee);
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		
		
		 System.out.println("Working Angular And SpringBoot Integration !! ");
		 return empservice.getAllEmployees();
	}
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/employees/{EmployeeId}")
	public ResponseEntity<Employee> getEmpId(@PathVariable Long EmployeeId)
	{
		Employee employee = empservice.getEmployeeId(EmployeeId);
		
		return ResponseEntity.ok(employee);
	}
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/employees/{EmployeeId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long EmployeeId, @RequestBody Employee employee)
	{
	    Employee updateEmployee = empservice.UpdateEmployee(employee);
	    
	    return ResponseEntity.ok(updateEmployee); 
	}
	
	@DeleteMapping("/employees/delete/{EmployeeId}")
	@CrossOrigin(origins="http://localhost:4200")
	public String deleteEmpId(@PathVariable Long EmployeeId)
	{
		return empservice.deleteEmployee(EmployeeId);
	}
	
}
 
