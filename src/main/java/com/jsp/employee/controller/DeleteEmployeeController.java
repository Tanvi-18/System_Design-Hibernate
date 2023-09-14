package com.jsp.employee.controller;

import com.jsp.employee.dto.Employee;
import com.jsp.employee.service.EmployeeService;

public class DeleteEmployeeController {
	
	public static void main(String[] args) {
		
		Employee employee = new Employee();
		
		EmployeeService employeeService = new EmployeeService();
		employeeService.deleteEmployee(6);
		
	}

}
