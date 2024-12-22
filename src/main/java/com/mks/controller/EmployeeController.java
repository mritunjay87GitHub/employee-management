package com.mks.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mks.entity.Department;
import com.mks.entity.Employee;
import com.mks.exception.ResponseHeaderException;
import com.mks.service.intf.DepartmentService;
import com.mks.service.intf.EmployeeService;

@Controller
@RequestMapping("esm/employee")
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping()
	public ModelAndView  employeeList() {
		LOGGER.info("Entry to EmployeeRestController >>> employeeList() method");
		 ModelAndView mav = new ModelAndView();
		 	List<Employee> employeeList = null;
			try {
				employeeList = employeeService.getEmployees();
				mav.addObject("employeeList", employeeList);
				mav.setViewName("employee-list");
				mav.addObject("isView", false);
				LOGGER.info("Exit from EmployeeRestController >>> employeeList() method");
			} catch (Exception exception) {
				LOGGER.error(exception.getMessage());
				throw new ResponseHeaderException(exception.getMessage());
			}
			return mav;
		
	}
	
	@GetMapping("/create")
	public ModelAndView  createEmployeeView() {
		LOGGER.info("Entry to EmployeeRestController >>> createEmployeeView() method");
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject("employee", new Employee());
			List<Department> departmentList = departmentService.getDepartments();
			modelAndView.addObject("departmentList", departmentList);
			modelAndView.setViewName("create-employee");
			LOGGER.info("Exit from EmployeeRestController >>> createEmployeeView() method");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return modelAndView;
		
	}
	
	@GetMapping("/edit/{empId}")
	public ModelAndView  editEmployeeView(@PathVariable("empId") Long empId) {
		LOGGER.info("Entry to EmployeeRestController >>> editEmployeeView() method");
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject("employee", employeeService.getEmployee(empId));
			List<Department> departmentList = departmentService.getDepartments();
			modelAndView.addObject("departmentList", departmentList);
			modelAndView.setViewName("create-employee");
			LOGGER.info("Exit from EmployeeRestController >>> editEmployeeView() method");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return modelAndView;
		
	}
	
	@GetMapping("/retrive/{employeeId}")
	public ModelAndView getEmployee(@PathVariable("employeeId") Long employeeId) {
		LOGGER.info("Entry to EmployeeRestController >>> getEmployee() method");
		ModelAndView mav = new ModelAndView();
		Employee employee = null;
		try {
			employee = employeeService.getEmployee(employeeId);
			mav.addObject("employeeDetail", employee);
			List<Employee> employeeList = employeeService.getEmployees();
			mav.addObject("employeeList", employeeList);
			mav.addObject("isView", true);
			mav.setViewName("employee-list");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getLocalizedMessage());
		}
		LOGGER.info("Exit from EmployeeRestController >>> getEmployee() method");
		return mav;
	}

	@PostMapping("/create-employee")
	public ModelAndView createEmployee(Employee employee) {
		try {
			LOGGER.info("Entry to EmployeeRestcreateEmployeeController >>> () method");
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
			employee = employeeService.saveEmployee(employee);
			LOGGER.info("Exit from EmployeeRestController >>> createEmployee() method");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return this.employeeList();
	}

	@GetMapping("/delete/{employeeId}")
	public ModelAndView deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		String message = "Success";
		try {
			LOGGER.info("Entry to EmployeeRestController >>> deleteEmployee() method --> {}", employeeId);
			message = employeeService.deleteEmployee(employeeId);
			LOGGER.info("Exit from EmployeeRestController >>> deleteEmployee() method");
		} catch (Exception exception) {
			message = "Failed";
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return this.employeeList().addObject("message",message);
	}

}
