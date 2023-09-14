package com.jsp.employee.controller;

import com.jsp.employee.dto.Employee;
import com.jsp.employee.service.EmployeeService;

public class SaveEmployeeController {
	
	public static void main(String[] args) {
		
		Employee employee = new Employee();
		
		employee.setName("TEJAS");
		employee.setEmail("tejas@mail.com");
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.saveEmployee(employee);
		
	}

}
