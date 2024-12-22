package com.mks.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
	
	@Test
	public void testGetEmployee() {
		Employee employee= new Employee();
		when(employeeRespositry.getReferenceById(2l)).thenReturn(employee);
		
		Employee employee2 = employeeRespositry.getReferenceById(2l);
		
		assertNotNull(employee2);
	    
		verify(employeeRespositry, times(1)).getReferenceById(2l);

	}
	
	

}
