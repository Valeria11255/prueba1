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
@Table(name="LOCATIONS")
public class LocationEntity {
	@Id
	@Column(name="LOCATION_ID")
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "LOCATIONS_SEQ")
	@SequenceGenerator(name = "LOCATIONS_SEQ",sequenceName = "LOCATIONS_SEQ" ,allocationSize=1)
	private Integer locationId;
	
	@Column(name="STREET_ADDRESS")
	private String streetAddress;
	
	@Column(name="POSTAL_CODE")
	private String postalCode;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE_PROVINCE")
	private String stateProvince;
	
	@Column(name="COUNTRY_ID")
	private String countryId;
	
	
	//location a departaments
	@OneToMany (mappedBy= "locationsEntity", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<DepartmentsEntity> departmentsEntity;
	
	
	
	//location a countries
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name="COUNTRY_ID", insertable=false, updatable=false)
	@JsonIgnore
	private CountriesEntity countriesEntity;
		
	public LocationEntity() {}

	public LocationEntity(Integer locationId, String streetAddress, String postalCode, String city,
			String stateProvince, String countryId, List<DepartmentsEntity> departmentsEntity,
			CountriesEntity countriesEntity) {
		super();
		this.locationId = locationId;
		this.streetAddress = streetAddress;
		this.postalCode = postalCode;
		this.city = city;
		this.stateProvince = stateProvince;
		this.countryId = countryId;
		this.departmentsEntity = departmentsEntity;
		this.countriesEntity = countriesEntity;
	}

	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public List<DepartmentsEntity> getDepartmentsEntity() {
		return departmentsEntity;
	}

	public void setDepartmentsEntity(List<DepartmentsEntity> departmentsEntity) {
		this.departmentsEntity = departmentsEntity;
	}

	public CountriesEntity getCountriesEntity() {
		return countriesEntity;
	}

	public void setCountriesEntity(CountriesEntity countriesEntity) {
		this.countriesEntity = countriesEntity;
	}

	
	
	
}
