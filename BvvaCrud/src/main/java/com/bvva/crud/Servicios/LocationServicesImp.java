package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.bvva.crud.Modelo.LocationEntity;
import com.bvva.crud.Repositorio.LocationRepository;

@Service
public class LocationServicesImp implements LocationServices{
	
	@Autowired
	private LocationRepository repoLocation;


	public List<LocationEntity> getLocations() {
		return repoLocation.findAll();
	}
	
	public ResponseEntity<Object> getLocation(Integer locationId) {
		return new ResponseEntity<>(repoLocation.findById(locationId), HttpStatus.OK);
	}
	
	public void deleteLocation(Integer locationId) {
		repoLocation.deleteById(locationId);
	}
	@Override
	public int save(LocationEntity location) {
		int res=0;
		LocationEntity locations = repoLocation.save(location);
		
		if(!locations.equals(null)){
			res= 1;
		}
		return 0;
	}
	
	@Override
	public Optional<LocationEntity> ID(int locationId) {
		return repoLocation.findById(locationId);
	}
	
	@Override
	public int modificar(LocationEntity location) {
		int res=0;
		int locationId =location.getLocationId();	
		if(repoLocation.findById(locationId).isPresent()) {
			LocationEntity l = new LocationEntity();
			l.setLocationId(location.getLocationId());
			l.setStreetAddress(location.getStreetAddress());
			l.setPostalCode(location.getPostalCode());
			l.setCity(location.getCity());
			l.setStateProvince(location.getStateProvince());
			l.setCountryId(location.getCountryId());
			repoLocation.save(l);
			res=1;
		}
		return 0;
	}
	}
