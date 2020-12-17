package com.bvva.crud.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bvva.crud.Modelo.CountriesEntity;


@Repository
public interface CountriesRepository extends JpaRepository<CountriesEntity, String> {
	
}
