package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bvva.crud.Modelo.CountriesEntity;
import com.bvva.crud.Repositorio.CountriesRepository;

@Service
public class CountriesServicesImp implements CountriesServices {

	@Autowired
	private CountriesRepository repoCountry;
	
	
	public List<CountriesEntity> getCountries(){
		return repoCountry.findAll();
	}
	
	
	public ResponseEntity<Object> getCountry(String countryId){
		return new ResponseEntity<>(repoCountry.findById(countryId), HttpStatus.OK);
	}
	
	public void deleteCountry(String countryId) {
		repoCountry.deleteById(countryId);
	}
	
	@Override
	public int save(CountriesEntity countries) {
		int res=0;
		CountriesEntity countrys =repoCountry.save(countries);
		if(!countrys.equals(null)) {
			res=1;
		}
		return 0;
	}


	@Override
	public Optional<CountriesEntity> ID(String countryId) {
		return repoCountry.findById(countryId);
	}
	
	@Override
	public int modificar(CountriesEntity countries) {
		int res=0;
		String countryId =countries.getCountryId();
		if(repoCountry.findById(countryId).isPresent()) {
			CountriesEntity ct = new CountriesEntity();
			ct.setCountryId(countries.getCountryId());
			ct.setCountryName(countries.getCountryName());
			ct.setRegionId(countries.getRegionId());
			repoCountry.save(ct);
			res= 1;
	}
		return 0;
		}
}
