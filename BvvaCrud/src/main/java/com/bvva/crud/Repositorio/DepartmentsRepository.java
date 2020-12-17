package com.bvva.crud.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bvva.crud.Modelo.DepartmentsEntity;

@Repository
public interface DepartmentsRepository  extends JpaRepository<DepartmentsEntity, Integer>{

}
