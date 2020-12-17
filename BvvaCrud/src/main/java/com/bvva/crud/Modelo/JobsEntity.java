package com.bvva.crud.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="JOBS")
public class JobsEntity {
	@Id
	@Column(name="JOB_ID")
	private String jobId;
	
	@Column(name="JOB_TITLE")
	private String jobTitle;
	
	@Column(name="MIN_SALARY")
	private Float minSalary;
	
	@Column(name="MAX_SALARY")
	private Float maxSalary;
	
	@OneToMany (mappedBy= "jobsEntity", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<EmployeesEntity> employeesEntity;
	
	
	
	public JobsEntity() {}



	public JobsEntity(String jobId, String jobTitle, Float minSalary, Float maxSalary,
			List<EmployeesEntity> employeesEntity) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employeesEntity = employeesEntity;
	}



	public String getJobId() {
		return jobId;
	}



	public void setJobId(String jobId) {
		this.jobId = jobId;
	}



	public String getJobTitle() {
		return jobTitle;
	}



	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}



	public Float getMinSalary() {
		return minSalary;
	}



	public void setMinSalary(Float minSalary) {
		this.minSalary = minSalary;
	}



	public Float getMaxSalary() {
		return maxSalary;
	}



	public void setMaxSalary(Float maxSalary) {
		this.maxSalary = maxSalary;
	}



	public List<EmployeesEntity> getEmployeesEntity() {
		return employeesEntity;
	}



	public void setEmployeesEntity(List<EmployeesEntity> employeesEntity) {
		this.employeesEntity = employeesEntity;
	}


	
}
