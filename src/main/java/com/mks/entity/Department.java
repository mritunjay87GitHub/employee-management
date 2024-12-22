package com.mks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMS_EMP_DEPARTMENT")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPT_ID_I")
	private Integer departmentId;
	@Column(name = "DEPT_NAME_C")
	private String departmentName;
	@Column(name = "DEPT_LOCATION_C")
	private String departmentLocation;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(final Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(final String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentLocation() {
		return departmentLocation;
	}

	public void setDepartmentLocation(final String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}

	@Override
	public String toString() {
		return "[departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", departmentLocation=" + departmentLocation + "]";
	}
	
	

}
