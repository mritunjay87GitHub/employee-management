package com.mks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mks.entity.Department;

@Repository
public interface DepartmentRespositry extends JpaRepository<Department, Integer>{

}
