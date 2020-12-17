package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import com.bvva.crud.Modelo.LocationEntity;

public interface LocationServices {
	
	public abstract List<LocationEntity> getLocations();
	public abstract ResponseEntity<Object> getLocation(Integer locationId);
	public abstract void deleteLocation (Integer locationId);
	
	public abstract int save(LocationEntity location);
	public Optional<LocationEntity>ID(int locationId);
	public abstract int modificar(LocationEntity location);
}
