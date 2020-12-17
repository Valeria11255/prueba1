package com.bvva.crud.Modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="EMPLOYEES")
public class EmployeesEntity {
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "EMPLOYEES_SEQ")
	@SequenceGenerator(name = "EMPLOYEES_SEQ",sequenceName = "EMPLOYEES_SEQ" ,allocationSize=1)
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="HIRE_DATE")
	private String hireDate;

	@Column(name="SALARY")
	private Float salary;
	
	@Column(name="COMMISSION_PCT")
	private Float commissionPct;
	
	@Column(name="MANAGER_ID")
	private Integer managerId;
	
	@Column(name="DEPARTMENT_ID")
	private Integer departmentId;

	@Column(name="JOB_ID")
	private String jobId;
	
	//employees a jobs
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name="JOB_ID", insertable=false, updatable=false)
	@JsonIgnore
	private JobsEntity jobsEntity;
	

	
	
	public EmployeesEntity() {}




	public EmployeesEntity(Integer employeeId, String firstName, String lastName, String email, String phoneNumber,
			String hireDate, Float salary, Float commissionPct, Integer managerId, Integer departmentId, String jobId,
			JobsEntity jobsEntity) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.managerId = managerId;
		this.departmentId = departmentId;
		this.jobId = jobId;
		this.jobsEntity = jobsEntity;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public Float getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(Float commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public JobsEntity getJobsEntity() {
		return jobsEntity;
	}

	public void setJobsEntity(JobsEntity jobsEntity) {
		this.jobsEntity = jobsEntity;
	}


}
