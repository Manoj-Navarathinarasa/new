package com.sgic.employee.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sgic.employee.dto.EmployeeDTO;
import com.sgic.employee.entities.Employee;
import com.sgic.employee.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
//	@Autowired
//	JavaMailSender javaMailSender;

	@Override
	public void saveEmployee(Employee employee) {
//		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setTo(employee.getEmail());
//		msg.setSubject("ghgkg");
//		msg.setText("dawadea");
		employeeRepository.save(employee);
//		javaMailSender.send(msg);
	}

	@Override
	public List<EmployeeDTO> employeeDetails() {

		return employeeRepository.findAll().stream().map(this::convertToEmployeeDto).collect(Collectors.toList());
	}

	public EmployeeDTO convertToEmployeeDto(Employee employee) {
		EmployeeDTO employeeDto = new EmployeeDTO();
//		employeeDto.setEmail(employee.getEmail());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		return employeeDto;
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employeeDetails) {

		Optional<Employee> emp = employeeRepository.findById(employeeId);
		Employee employee = emp.get();
		employee.setEmail(employeeDetails.getEmail());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public void deleteDetails(Long employeeId) {
		employeeRepository.deleteById(employeeId);
	}

}
