package com.mks.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.mks.exception.ResponseHeaderException;
import com.mks.service.intf.DepartmentService;

@Controller
@RequestMapping("ems/department")
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/retrieve/{deptId}")
	public ModelAndView getDepartment(@PathVariable("deptId") Integer deptId) {
		ModelAndView mav = new ModelAndView();
		Department department = null;
		try {
			LOGGER.info("Entry to DepartmentRestController >>> getDepartment() method --> {}", deptId);
			department = departmentService.getDepartment(deptId);
			mav.addObject("department", department);
			mav.addObject("isView", true);
			
			List<Department> departmentList = departmentService.getDepartments();
			mav.setViewName("department-list");
			mav.addObject("departmentList", departmentList);
			
			LOGGER.info("Exit from DepartmentRestController >>> getDepartment() method");
		} catch (Exception exception) {
			LOGGER.error("Department not found");
		}
		return mav;
	}

	@GetMapping("/retrieves")
	public ModelAndView getDepartmentList() {
		ModelAndView mav = new ModelAndView();
		List<Department> departmentList = null;
		try {
			LOGGER.info("Entry to DepartmentRestController >>> getDepartmentList() method");
			departmentList = departmentService.getDepartments();
			mav.setViewName("department-list");
			mav.addObject("departmentList", departmentList);
			mav.addObject("isView", false);
			LOGGER.info("Exit from DepartmentRestController >>> getDepartmentList() method");
		} catch (Exception exception) {
			LOGGER.error("Employee not found");
		}
		return mav;
	}
	
	@GetMapping("/create")
	public ModelAndView  createDepartmentPage() {
		LOGGER.info("Entry to DepartmentRestController >>> createDepartmentPage() method");
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject("department", new Department());
			modelAndView.setViewName("create-department");
			LOGGER.info("Exit from DepartmentRestController >>> createDepartmentPage() method");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return modelAndView;
		
	}

	@PostMapping("/save")
	public ModelAndView createDepartment(Department department) {
		try {
			LOGGER.info("Entry to DepartmentRestController >>> createDepartment() method");
			department = departmentService.saveDepartment(department);
			LOGGER.info("Exit from DepartmentRestController >>> createDepartment() method");
		} catch (Exception exception) {
			LOGGER.error("Employee not found");
		}
		return getDepartmentList();
	}

	@GetMapping("/edit/{deptId}")
	public ModelAndView updateDepartment(@PathVariable("deptId") Integer deptId) {
		LOGGER.info("Entry to DepartmentRestController >>> createDepartmentPage() method");
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject("department", departmentService.getDepartment(deptId));
			modelAndView.setViewName("create-department");
			LOGGER.info("Exit from DepartmentRestController >>> createDepartmentPage() method");
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException(exception.getMessage());
		}
		return modelAndView;
		
	}

	@GetMapping("/delete/{deptId}")
	public ModelAndView deleteDepartment(@PathVariable("deptId") Integer deptId) {
		String message = null;
		try {
			LOGGER.info("Entry to DepartmentRestController >>> deleteDepartment() method --> {}", deptId);
			message = departmentService.deleteDepartment(deptId);
			LOGGER.info("Exit from DepartmentRestController >>> deleteDepartment() method");
		} catch (Exception exception) {
			LOGGER.error("Department not found");
		}
		return getDepartmentList();
	}
}
