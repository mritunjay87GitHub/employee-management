package com.mks.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mks.entity.Employee;
import com.mks.exception.ResponseHeaderException;
import com.mks.repository.EmployeeRespositry;
import com.mks.service.intf.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRespositry employeeRespositry;

	@Override
	public Employee getEmployee(final Long employeeId) throws ResponseHeaderException {
		Employee employee = null;
		try {
			LOGGER.info("Entry to EmployeeServiceImpl >>> getEmployee() method ");
			employee = employeeRespositry.getReferenceById(employeeId);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Employee not found for the id " + employeeId);
		}

		LOGGER.info("Exit from EmployeeServiceImpl >>> getEmployee() method");
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employeeList = null;
		try {
			LOGGER.info("Entry to EmployeeServiceImpl >>> getEmployees() method ");
			employeeList = employeeRespositry.findAll();
			employeeList = employeeList.stream().filter(emp->emp.getDepartment() != null).collect(Collectors.toList());
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Employee not found.");
		}

		LOGGER.info("Exit from EmployeeServiceImpl >>> getEmployees() method");

		return employeeList;

	}

	@Override
	public Employee saveEmployee(final Employee employee) {
		Employee newCmployee = null;
		try {
			LOGGER.info("Entry to EmployeeServiceImpl >>> saveEmployee() method ");
			newCmployee = employeeRespositry.save(employee);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Unable to create Employee");
		}

		LOGGER.info("Exit from EmployeeServiceImpl >>> saveEmployee() method");
		return newCmployee;
	}

	@Override
	public Employee updateEmployee(final Employee employee) {
		Employee newCmployee = null;
		try {
			LOGGER.info("Entry to EmployeeServiceImpl >>> updateEmployee() method ");
			newCmployee = employeeRespositry.save(employee);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Unable to update Employee");
		}

		LOGGER.info("Exit from EmployeeServiceImpl >>> updateEmployee() method");
		return newCmployee;
	}

	@Override
	public String deleteEmployee(final Long employeeId) {
		String message = "Success";
		try {
			LOGGER.info("Entry to EmployeeServiceImpl >>> deleteEmployee() method ");
			employeeRespositry.deleteById(employeeId);
		} catch (Exception exception) {
			message = "Failed";
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Unable to delete Employee");
		}

		LOGGER.info("Exit from EmployeeServiceImpl >>> deleteEmployee() method");

		return message;

	}

	@Override
	public Employee findByUserName(String userName) throws Exception {

		Employee employee = null;
		try {
			LOGGER.info("Entry to EmployeeServiceImpl >>> findByUserName() method ");
			employee = employeeRespositry.findByUserName(userName);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Employee not found for the userName" + userName);
		}

		LOGGER.info("Exit from EmployeeServiceImpl >>> findByUserName() method");
		return employee;
	
	}

}
