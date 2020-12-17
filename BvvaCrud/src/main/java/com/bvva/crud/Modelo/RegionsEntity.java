package com.bvva.crud.Modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
@Table(name="REGIONS")
public class RegionsEntity {
	@Id
	@NotNull
	@Column(name="REGION_ID")
	private Integer regionId;
	
	@Column(name="REGION_NAME")
	private String regionName;
	
	@OneToMany (mappedBy= "regionsEntity", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CountriesEntity> countriesEntity;
	
	public RegionsEntity() {}

	public RegionsEntity(Integer regionId, String regionName, List<CountriesEntity> countriesEntity) {
		super();
		this.regionId = regionId;
		this.regionName = regionName;
		this.countriesEntity = countriesEntity;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public List<CountriesEntity> getCountriesEntity() {
		return countriesEntity;
	}

	public void setCountriesEntity(List<CountriesEntity> countriesEntity) {
		this.countriesEntity = countriesEntity;
	}

	@Override
	public String toString() {
		return "RegionsEntity [regionId=" + regionId + ", regionName=" + regionName + ", countriesEntity="
				+ countriesEntity + "]";
	}
}
