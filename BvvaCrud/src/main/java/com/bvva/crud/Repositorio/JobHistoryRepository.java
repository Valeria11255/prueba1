package com.bvva.crud.Repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bvva.crud.Modelo.JobHistoryEntity;


@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistoryEntity, Integer >{

	
	
	
}
