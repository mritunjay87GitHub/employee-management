package com.mks.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "EMS_EMPLOYEE_DTAILS")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMP_ID_I")
	private Long empId;
	@Column(name = "EMP_F_NAME_C")
	private String firstName;
	@Column(name = "EMP_M_NAME_C")
	private String middleName;
	@Column(name = "EMP_L_NAME_C")
	private String lastName;
	@Column(name = "EMP_EMAIL_ID_C")
	private String emailId;
	@Column(name = "EMP_U_NAME_C")
	private String userName;
	@Column(name = "EMP_PASSWORD_C")
	private String password;
	
	//@Column(name = "EMP_DEPT_ID_I")
	@OneToOne
	@JoinColumn(name = "EMP_DEPT_ID_I", referencedColumnName = "DEPT_ID_I")
	private Department department;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(final Long empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(final String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(final Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "[empId=" + empId + ", firstName=" + firstName + ", emailId=" + emailId + ", userName=" + userName +  ", department=" + department + "]";
	}
	
	

}
