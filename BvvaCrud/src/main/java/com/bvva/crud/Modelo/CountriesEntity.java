package com.bvva.crud.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="COUNTRIES")
public class CountriesEntity {
	@Id
	@Column(name="COUNTRY_ID")
	private String countryId;
	
	@Column(name="COUNTRY_NAME")
	private String countryName;
	
	@Column(name="REGION_ID")
	private Integer regionId;
	
	//countries a regions
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn (name="REGION_ID", insertable=false, updatable=false)
	@JsonIgnore
	private RegionsEntity regionsEntity;

	
	//location a countries
	@OneToMany (mappedBy= "countriesEntity",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<LocationEntity> locationsEntity;
	
	
	public CountriesEntity() {}


	public CountriesEntity(String countryId, String countryName, Integer regionId, RegionsEntity regionsEntity,
			List<LocationEntity> locationsEntity) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.regionId = regionId;
		this.regionsEntity = regionsEntity;
		this.locationsEntity = locationsEntity;
	}


	public String getCountryId() {
		return countryId;
	}


	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}


	public String getCountryName() {
		return countryName;
	}


	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}


	public Integer getRegionId() {
		return regionId;
	}


	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}


	public RegionsEntity getRegionsEntity() {
		return regionsEntity;
	}


	public void setRegionsEntity(RegionsEntity regionsEntity) {
		this.regionsEntity = regionsEntity;
	}


	public List<LocationEntity> getLocationsEntity() {
		return locationsEntity;
	}


	public void setLocationsEntity(List<LocationEntity> locationsEntity) {
		this.locationsEntity = locationsEntity;
	}


	
}
