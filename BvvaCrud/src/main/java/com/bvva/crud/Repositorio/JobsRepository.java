package com.bvva.crud.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bvva.crud.Modelo.JobsEntity;

@Repository
public interface JobsRepository extends JpaRepository<JobsEntity, String>{

}
