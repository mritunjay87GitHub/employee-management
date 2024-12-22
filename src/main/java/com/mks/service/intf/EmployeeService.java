package com.mks.service.intf;

import java.util.List;

import com.mks.entity.Employee;

public interface EmployeeService {

	public Employee getEmployee(final Long employeeId) throws Exception;

	public List<Employee> getEmployees() throws Exception;

	public Employee saveEmployee(final Employee employee) throws Exception;

	public Employee updateEmployee(final Employee employee) throws Exception;

	public String deleteEmployee(final Long employeeId) throws Exception;
	
	public Employee findByUserName(final String userName) throws Exception;

}
