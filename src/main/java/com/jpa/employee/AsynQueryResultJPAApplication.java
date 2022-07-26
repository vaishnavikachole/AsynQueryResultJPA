package com.jpa.employee;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.jpa.employee.entities.Employee;
import com.jpa.employee.service.EmployeeService;

@SpringBootApplication
@EnableAsync
public class AsynQueryResultJPAApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;
	
	public static void main(String[] args) {
		SpringApplication.run(AsynQueryResultJPAApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		CompletableFuture<Employee> completableFuture = employeeService.findByEmail("shreya98@gmail.com");
		Employee employee = completableFuture.get(20, TimeUnit.SECONDS);
		System.out.println(employee);
	
	}

	

}
