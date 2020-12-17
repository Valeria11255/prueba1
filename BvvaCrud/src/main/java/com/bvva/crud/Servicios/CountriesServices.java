package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.bvva.crud.Modelo.CountriesEntity;


public interface CountriesServices {
	public abstract List<CountriesEntity> getCountries();
	public abstract ResponseEntity<Object> getCountry(String countryId);
	public abstract void deleteCountry (String countryId);
	
	public abstract int save(CountriesEntity countries);
	public Optional<CountriesEntity>ID(String countryId);
	public abstract int modificar(CountriesEntity countries);

}
