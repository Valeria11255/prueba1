package com.bvva.crud.Modelo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
//@IdClass(CompositeKey.class)
@Table(name="JOB_HISTORY")
public class JobHistoryEntity {
	@Id
	@Column(name="EMPLOYEE_ID")
	private Integer employeeId;	
	
	@Column(name="START_DATE")
	//@Temporal(TemporalType.DATE)
	private String startDate;
	
	@Column(name="END_DATE")
	private String endDate;
	
	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(name="DEPARTMENT_ID")
	private Integer departmentId;
	
	public JobHistoryEntity() {}

	public JobHistoryEntity(Integer employeeId, String startDate, String endDate, String jobId, Integer departmentId) {
		super();
		this.employeeId = employeeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.jobId = jobId;
		this.departmentId = departmentId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	@Override
	public String toString() {
		return "JobHistoryEntity [employeeId=" + employeeId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", jobId=" + jobId + ", DepartmentId=" + departmentId + "]";
	}

	
	
}
