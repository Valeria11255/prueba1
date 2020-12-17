package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.bvva.crud.Modelo.RegionsEntity;

public interface RegionsServices {
	public abstract List<RegionsEntity> getRegions();
	public abstract ResponseEntity<Object> getRegion(Integer regionId);
	public abstract void deleteRegions(Integer regionId);
	//tabla
	public abstract int save(RegionsEntity region);
	public Optional<RegionsEntity>ID(int regionId);
	public abstract int modificar(RegionsEntity region);
	/*
	List<RegionsEntity> findDescriptionEmp();
	*/
}
