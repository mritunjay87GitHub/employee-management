package com.mks.restapi;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mks.entity.Department;
import com.mks.service.intf.DepartmentService;

@RestController
@RequestMapping("ems/department")
public class DepartmentRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentRestController.class);

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/retrieve/{deptId}")
	public Department getDepartment(@PathVariable("deptId") Integer deptId) {
		Department department = null;
		try {
			LOGGER.info("Entry to DepartmentRestController >>> getDepartment() method --> {}", deptId);
			department = departmentService.getDepartment(deptId);
			LOGGER.info("Exit from DepartmentRestController >>> getDepartment() method");
		} catch (Exception exception) {
			LOGGER.error("Department not found");
		}
		return department;
	}

	@GetMapping("/retrieve-all")
	public List<Department> getDepartmentList() {
		List<Department> departmentList = null;
		try {
			LOGGER.info("Entry to DepartmentRestController >>> getDepartmentList() method");
			departmentList = departmentService.getDepartments();
			LOGGER.info("Exit from DepartmentRestController >>> getDepartmentList() method");
		} catch (Exception exception) {
			LOGGER.error("Employee not found");
		}
		return departmentList;
	}

	@PostMapping("/save")
	public Department createDepartment(@RequestBody Department department) {
		try {
			LOGGER.info("Entry to DepartmentRestController >>> createDepartment() method");
			department = departmentService.saveDepartment(department);
			LOGGER.info("Exit from DepartmentRestController >>> createDepartment() method");
		} catch (Exception exception) {
			LOGGER.error("Employee not found");
		}
		return department;
	}

	@PutMapping("/edit")
	public Department updateDepartment(@RequestBody Department department) {
		try {
			LOGGER.info("Entry to DepartmentRestController >>> updateDepartment() method");
			department = departmentService.updateDepartment(department);
			LOGGER.info("Exit from DepartmentRestController >>> updateDepartment() method");
		} catch (Exception exception) {
			LOGGER.error("Employee not found");
		}
		return department;
	}

	@DeleteMapping("/delete/{deptId}")
	public String deleteDepartment(@PathVariable("deptId") Integer deptId) {
		String message = null;
		try {
			LOGGER.info("Entry to DepartmentRestController >>> deleteDepartment() method --> {}", deptId);
			message = departmentService.deleteDepartment(deptId);
			LOGGER.info("Exit from DepartmentRestController >>> deleteDepartment() method");
		} catch (Exception exception) {
			LOGGER.error("Department not found");
		}
		return message;
	}
}
