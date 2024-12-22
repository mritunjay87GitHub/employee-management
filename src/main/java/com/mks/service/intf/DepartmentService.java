package com.mks.service.intf;

import java.math.BigInteger;
import java.util.List;

import com.mks.entity.Department;

public interface DepartmentService {

	public Department getDepartment(final Integer departmentId);

	public List<Department> getDepartments();

	public Department saveDepartment(final Department department);

	public Department updateDepartment(final Department department);

	public String deleteDepartment(final Integer departmentId);

}
