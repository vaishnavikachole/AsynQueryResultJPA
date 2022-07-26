package com.jpa.employee.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.employee.dao.EmployeeDao;
import com.jpa.employee.entities.Employee;

@Service
public class EmployeeService {

	
	@Autowired
	EmployeeDao employeeDao;

	public CompletableFuture<Employee> findByEmail(String email) {
		
		return employeeDao.findByEmail(email);
	}

	
}
