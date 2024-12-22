package com.mks.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.mks.entity.Department;
import com.mks.entity.Employee;
import com.mks.repository.EmployeeRespositry;
import com.mks.service.impl.EmployeeServiceImpl;
import com.mks.service.intf.EmployeeService;



@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	@Mock
	private EmployeeRespositry employeeRespositry;
	
	
	
	public static Employee context() {
		
		Employee employee= new Employee();
		
		employee.setFirstName("EMSJunit");
		employee.setMiddleName("EMSJunit");
		employee.setLastName("EMSJunit");
		employee.setEmailId("EMSJunit@gmail.com");
		employee.setFirstName("EMSJunit");
		
		Department department = new Department();
		department.setDepartmentLocation("EMSJunit");
		department.setDepartmentLocation("EMSJunit");
		
		employee.setDepartment(department);
		
		return employee;
	}
	
	@Test
	public void testGetEmployee() {
		Employee employee= context();
		when(employeeRespositry.getReferenceById(2l)).thenReturn(employee);
		
		Employee employee2 = employeeService.getEmployee(2l);
		
		assertNotNull(employee2);
	    
		verify(employeeRespositry, times(1)).getReferenceById(2l);

	}
	
	@Test
	public void testGetEmployees() {
		
		List<Employee> employeeList = Arrays.asList(context());
		
		when(employeeRespositry.findAll()).thenReturn(employeeList);
		
		List<Employee> empList = employeeService.getEmployees();
		
		assertNotNull(empList);
		
		verify(employeeRespositry, times(1)).findAll();
		
	}
	
	@Test
	public void testSaveEmployee() {
		
		Employee employee= context();
		
		employeeService.saveEmployee(employee);
		
		verify(employeeRespositry, times(1)).save(employee);
		
	}
	
	@Test
	public void testUpdateEmployee() {
		
		Employee employee= context();
		
		employee.setFirstName("UpdateEMSJunit");
		
		employeeService.updateEmployee(employee);
		
		verify(employeeRespositry, times(1)).save(employee);
		
	}
	
	@Test
	public void testDeleteEmployee() {
		
		String msg = employeeService.deleteEmployee(111l);
		
		assertNotNull(msg);
		
		verify(employeeRespositry, times(1)).deleteById(111l);; 
		
	}
	
	@Test
	public void testFindByUserName() throws Exception {
		
		Employee employee= context();
		
		when(employeeRespositry.findByUserName("Aadya123")).thenReturn(employee);
		
		Employee employee2 = employeeService.findByUserName("Aadya123");
		
		assertNotNull(employee2);
		
		verify(employeeRespositry, times(1)).findByUserName("Aadya123");
		
	}
	
	

}
