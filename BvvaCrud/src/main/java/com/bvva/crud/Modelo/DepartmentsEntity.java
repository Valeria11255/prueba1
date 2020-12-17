package com.bvva.crud.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="DEPARTMENTS")
public class DepartmentsEntity {
	@Id
	@Column(name="DEPARTMENT_ID")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "DEPARTMENTS_SEQ")
	@SequenceGenerator(name = "DEPARTMENTS_SEQ",sequenceName = "DEPARTMENTS_SEQ" ,allocationSize=1)
	private Integer departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="MANAGER_ID")
	private Integer managerId;
	
	@Column(name="LOCATION_ID")
	private Integer locationId;

	//Department a Location 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn (name="LOCATION_ID", insertable=false, updatable=false)
	@JsonIgnore
	private LocationEntity locationsEntity;
	
	
	
	public DepartmentsEntity() {}



	public DepartmentsEntity(Integer departmentId, String departmentName, Integer managerId, Integer locationId,
			LocationEntity locationsEntity) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.locationId = locationId;
		this.locationsEntity = locationsEntity;
	}



	public Integer getDepartmentId() {
		return departmentId;
	}



	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	public Integer getManagerId() {
		return managerId;
	}



	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}



	public Integer getLocationId() {
		return locationId;
	}



	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}



	public LocationEntity getLocationsEntity() {
		return locationsEntity;
	}



	public void setLocationsEntity(LocationEntity locationsEntity) {
		this.locationsEntity = locationsEntity;
	}
	

}
