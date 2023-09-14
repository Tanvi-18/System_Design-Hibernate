package com.jsp.employee.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.employee.dto.Employee;

public class EmployeeDao {
	
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("tanvi");
	
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	// to save 
	public Employee saveEmployee(Employee employee) {
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		
		return employee;
	}
	
	// to delete
	public Employee deleteEmployee(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		
		if(employee != null) {
			entityTransaction.begin();
			entityManager.remove(employee);
			entityTransaction.commit();
		}
		else {
			System.out.println("Not deleted");
		}
		return employee;
	}
	
	// to update
	public Employee updateEmployeeMailById(int id, String email) {
		
		Employee employee = entityManager.find(Employee.class, id);
		employee.setEmail(email);
		
		if(employee!=null) {
			entityTransaction.begin();
			entityManager.merge(employee);
			entityTransaction.commit();
			
		}
		
		return employee;
		
	}
	
	public Employee getEmployeeById(int id) {
		Employee employee = entityManager.find(Employee.class, 1);
		
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getEmail());
		
		return employee;
	}
	
	
	public List<Employee> getAllEmployee() {
		
		String sql = "SELECT e FROM Employee e";  			// HQL Query
		Query query = entityManager.createQuery(sql); 		// used to create custom query
		
		List<Employee> employees = query.getResultList();	// used to get multiple values
		
		for(Employee e : employees) {
			System.out.println("================");
			System.out.println(e.getId());
			System.out.println(e.getName());
			System.out.println(e.getEmail());
			System.out.println("================");			
		}
		
		return employees;
	}
	

}
