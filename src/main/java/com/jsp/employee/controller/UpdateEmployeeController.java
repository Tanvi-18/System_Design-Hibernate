package com.jsp.employee.controller;

import com.jsp.employee.dto.Employee;
import com.jsp.employee.service.EmployeeService;

public class UpdateEmployeeController {
	
	public static void main(String[] args) {
	
		EmployeeService employeeService = new EmployeeService();
		Employee e = employeeService.updateEmployeeMailById(1,"abc@mail.com");
		
		if(e!= null) {
			System.out.println(e.getId() + " Updated");
		}
		
		
	}

}
