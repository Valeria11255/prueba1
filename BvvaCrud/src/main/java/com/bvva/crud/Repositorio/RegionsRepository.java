package com.bvva.crud.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bvva.crud.Modelo.RegionsEntity;


@Repository
public interface RegionsRepository extends JpaRepository<RegionsEntity, Integer>{
	/*
	@Query("select c.country_name, r.region_name\r\n"
			+ "from countries c, regions r\r\n"
			+ "where c.country_id=c.country_id and\r\n"
			+ "r.region_id= r.region_id")
	public List<RegionsEntity>findDescriptionEmp();
	*/

}
