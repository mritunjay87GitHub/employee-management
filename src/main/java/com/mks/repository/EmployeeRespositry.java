package com.mks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mks.entity.Employee;

@Repository
public interface EmployeeRespositry extends JpaRepository<Employee, Long>{
	         //findByUserNameIgnoreCase(String email)
	public Employee findByUserName(final String userName) throws Exception;

}
