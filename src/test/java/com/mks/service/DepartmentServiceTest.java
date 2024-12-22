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
import com.mks.repository.DepartmentRespositry;
import com.mks.repository.EmployeeRespositry;
import com.mks.service.impl.DepartmentServiceImpl;
import com.mks.service.impl.EmployeeServiceImpl;
import com.mks.service.intf.EmployeeService;



@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
	
	@InjectMocks
	private DepartmentServiceImpl departmentService;
	
	@Mock
	private DepartmentRespositry departmentRespositry;
	
	private static final int DEPT_ID = 111;
	
	public static Department context() {
		
		Department department = new Department();
		
		department.setDepartmentId(DEPT_ID);
		department.setDepartmentLocation("EMSJunit");
		department.setDepartmentLocation("EMSJunit");
		
		return department;
	}
	
	@Test
	public void testGetDepartment() {
		
		Department department= context();
		
		when(departmentRespositry.getReferenceById(DEPT_ID)).thenReturn(department);
		
		Department department2 = departmentService.getDepartment(DEPT_ID);
		
		assertNotNull(department2);
	    
		verify(departmentRespositry, times(1)).getReferenceById(DEPT_ID);

	}
	
	@Test
	public void testGetDepartments() {
		
		List<Department> departmentList = Arrays.asList(context());
		
		when(departmentRespositry.findAll()).thenReturn(departmentList);
		
		List<Department> deptList = departmentService.getDepartments();
		
		assertNotNull(deptList);
		
		verify(departmentRespositry, times(1)).findAll();
		
	}
	
	@Test
	public void testSaveDepartment() {
		
		Department department= context();
		
		departmentService.saveDepartment(department);
		
		verify(departmentRespositry, times(1)).save(department);
		
	}
	
	@Test
	public void testUpdateDepartment() {
		
		Department department= context();
		
		departmentService.updateDepartment(department);
		
		verify(departmentRespositry, times(1)).save(department);
		
	}
	
	@Test
	public void testDeleteEmployee() {
		
		String msg = departmentService.deleteDepartment(DEPT_ID);
		
		assertNotNull(msg);
		
		verify(departmentRespositry, times(1)).deleteById(DEPT_ID);
		
	}
	
	
}
