package com.jpa.employee.dao;

import java.util.concurrent.CompletableFuture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import com.jpa.employee.entities.Employee;

public interface EmployeeDao extends CrudRepository<Employee, Integer>
{
	@Async
	CompletableFuture<Employee> findByEmail(String email);
	
}
