package com.mks.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mks.entity.Department;
import com.mks.entity.Employee;
import com.mks.repository.EmployeeRespositry;
import com.mks.service.impl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {
	
	private static final Long EMP_ID = 2l;

	@InjectMocks
	private EmployeeController employeeController;
	
	@Mock
	private EmployeeServiceImpl empServiceImpl;
	
	@Mock
	private EmployeeRespositry employeeRespositry;
	
public static Employee context() {
		
		Employee employee= new Employee();
		
		employee.setEmpId(EMP_ID);
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
		 MockHttpServletRequest request = new MockHttpServletRequest();
	     RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	     
	     when(employeeRespositry.getReferenceById(2l)).thenReturn(context());
	     
	     ModelAndView mav = employeeController.getEmployee(EMP_ID);
	     
	     assertThat(mav).isNull();

	}
}
