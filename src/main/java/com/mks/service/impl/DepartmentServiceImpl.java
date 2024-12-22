package com.mks.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mks.entity.Department;
import com.mks.entity.Employee;
import com.mks.exception.ResponseHeaderException;
import com.mks.repository.DepartmentRespositry;
import com.mks.service.intf.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRespositry departmentRespositry;
	@Override
	public Department getDepartment(final Integer departmentId) {
		Department department = null;
		try {
			LOGGER.info("Entry to DepartmentServiceImpl >>> getDepartment() method ");
			department = departmentRespositry.getReferenceById(departmentId);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Department not found for the id " + departmentId);
		}

		LOGGER.info("Exit from DepartmentServiceImpl >>> getDepartment() method");
		return department;
	}

	@Override
	public List<Department> getDepartments() {
		List<Department> departmentList = null;
		try {
			LOGGER.info("Entry to DepartmentServiceImpl >>> getDepartments() method ");
			departmentList = departmentRespositry.findAll();
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Department not found. Please try Again Leter !!!");
		}

		LOGGER.info("Exit from DepartmentServiceImpl >>> getDepartments() method");
		return departmentList;
	}

	@Override
	public Department saveDepartment(final Department department) {
		Department newDepartment = null;
		try {
			LOGGER.info("Entry to DepartmentServiceImpl >>> saveDepartment() method ");
			newDepartment = departmentRespositry.save(department);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Unable to Create Department. Please try Again Leter !!!");
		}

		LOGGER.info("Exit from DepartmentServiceImpl >>> saveDepartment() method");
		return newDepartment;
	}

	@Override
	public Department updateDepartment(final Department department) {
		Department newDepartment = null;
		try {
			LOGGER.info("Entry to DepartmentServiceImpl >>> updateDepartment() method ");
			newDepartment = departmentRespositry.save(department);
		} catch (Exception exception) {
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Unable to Update Department. Please try Again Leter !!!");
		}

		LOGGER.info("Exit from DepartmentServiceImpl >>> updateDepartment() method");
		return newDepartment;
	}

	@Override
	public String deleteDepartment(final Integer departmentId) {
		String message = "Success";
		try {
			LOGGER.info("Entry to DepartmentServiceImpl >>> deleteDepartment() method ");
			departmentRespositry.deleteById(departmentId);
		} catch (Exception exception) {
			message = "Failed";
			LOGGER.error(exception.getMessage());
			throw new ResponseHeaderException("Unable to delete Department. Please try Again Leter !!!");
		}

		LOGGER.info("Exit from DepartmentServiceImpl >>> deleteDepartment() method");

		return message;

	}

}
