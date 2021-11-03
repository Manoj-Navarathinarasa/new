package com.sgic.employee.service;

import java.util.List;

import com.sgic.employee.dto.EmployeeDTO;
import com.sgic.employee.entities.Employee;

public interface EmployeeService {
	void saveEmployee(Employee employee);

	List<EmployeeDTO> employeeDetails();

	Employee updateEmployee(Long employeeId, Employee employee);

	void deleteDetails(Long employeeId);

}
