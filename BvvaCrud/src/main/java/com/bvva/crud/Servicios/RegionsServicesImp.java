package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bvva.crud.Modelo.RegionsEntity;
import com.bvva.crud.Repositorio.RegionsRepository;
//METODOS

@Service
public class RegionsServicesImp implements RegionsServices{
	@Autowired
	private RegionsRepository repoRegions;
	
	
	@Override
	public List<RegionsEntity> getRegions() {
		return repoRegions.findAll();
	}

	@Override
	public ResponseEntity<Object> getRegion(Integer regionId) {
		return new ResponseEntity<>(repoRegions.findById(regionId), HttpStatus.OK);
	}
	
//ELIMINAR
	@Override
	public void deleteRegions(Integer regionId) {
		repoRegions.deleteById(regionId);
		
	}
//AGREGAR
	@Override
	public int save(RegionsEntity region) {
		int res=0;
		RegionsEntity regiones = repoRegions.save(region);
		if(!regiones.equals(null)){
			res= 1;
		}
		return 0;
	}

	//LISTAR POR ID
	@Override
	public Optional<RegionsEntity> ID(int regionId) {
		return repoRegions.findById(regionId);
	}

	@Override
	public int modificar(RegionsEntity region) {
		int res=0;
		int regionId =region.getRegionId();
		if(repoRegions.findById(regionId).isPresent()) {
			RegionsEntity rg = new RegionsEntity();
			rg.setRegionId(region.getRegionId());
			rg.setRegionName(region.getRegionName());
			repoRegions.save(rg);
			res=1;
		}
		return 0;
	}
	
	
	/*
	//CONSULTA PRUEBA

	@Override
	public List<RegionsEntity> findDescriptionEmp() {
		List<RegionsEntity> regions =(List<RegionsEntity>) repoRegions.findDescriptionEmp();
		return regions;
	}
	
	*/

	
}
