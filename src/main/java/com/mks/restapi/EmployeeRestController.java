package com.mks.restapi;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mks.entity.Department;
import com.mks.entity.Employee;
import com.mks.exception.ResponseHeaderException;
import com.mks.service.intf.DepartmentService;
import com.mks.service.intf.EmployeeService;

//@RestController
@Controller
//@RequestMapping("employee-management")
@RequestMapping("esm/employee")
public class EmployeeRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeRestController.class);

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	 //@GetMapping("/")
	 @GetMapping()
	public ModelAndView  employeeList() {
		LOGGER.info("Entry to EmployeeRestController >>> employeeList() method");
		 ModelAndView modelAndView = new ModelAndView();
		 	List<Employee> employeeList = null;
			try {
				employeeList = employeeService.getEmployees();
				LOGGER.info("employeeList====>{}",employeeList);
				modelAndView.addObject("employeeList", employeeList);
				modelAndView.setViewName("employee-list");
				LOGGER.info("Exit from EmployeeRestController >>> employeeList() method");
			} catch (Exception exception) {
				LOGGER.error(exception.getMessage());
				throw new ResponseHeaderException(exception.getMessage());
			}
			return modelAndView;
		
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
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") Long employeeId) {
		LOGGER.info("Entry to EmployeeRestController >>> getEmployee() method");
		Employee employee = null;
		try {
			employee = employeeService.getEmployee(employeeId);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getLocalizedMessage());
		}
		LOGGER.info("Exit from EmployeeRestController >>> getEmployee() method");
		return employee;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		List<Employee> employeeList = null;
		try {
			LOGGER.info("Entry to EmployeeRestController >>> getEmployees() method");
			employeeList = employeeService.getEmployees();
			LOGGER.info("Exit from EmployeeRestController >>> getEmployees() method");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return employeeList;
	}

	@PostMapping("/create-employee")
	public ModelAndView createEmployee(Employee employee) {
		try {
			LOGGER.info("Entry to EmployeeRestcreateEmployeeController >>> () method");
			//LOGGER.info("{} -> {}",employee.getPassword(),passwordEncoder.encode(employee.getPassword()));
			employee.setPassword(passwordEncoder.encode(employee.getPassword()));
			employee = employeeService.saveEmployee(employee);
			LOGGER.info("Exit from EmployeeRestController >>> createEmployee() method");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return this.employeeList();
	}
	
	@PostMapping("/save-employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		try {
			LOGGER.info("Entry to EmployeeRestcreateEmployeeController >>> () method -> {}", employee);
			employee = employeeService.saveEmployee(employee);
			LOGGER.info("Exit from EmployeeRestController >>> createEmployee() method");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return employee;
	}

	@PutMapping("/edit-employee")
	public Employee updateEmployee(@RequestBody Employee employee) {
		try {
			LOGGER.info("Entry to EmployeeRestController >>> updateEmployee() method");
			employee = employeeService.updateEmployee(employee);
			LOGGER.info("Exit from EmployeeRestController >>> updateEmployee() method");
		} catch (Exception exception) {
			LOGGER.error("Employee not found");
		}
		return employee;
	}

	@DeleteMapping("/employee/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") Long employeeId) {
		String message = "Success";
		try {
			LOGGER.info("Entry to EmployeeRestController >>> deleteEmployee() method --> {}", employeeId);
			employeeService.deleteEmployee(employeeId);
			LOGGER.info("Exit from EmployeeRestController >>> deleteEmployee() method");
		} catch (Exception exception) {
			message = "Failed";
			LOGGER.error("Employee not found");
		}
		return message;
	}

}
