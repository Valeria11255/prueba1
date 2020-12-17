package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import com.bvva.crud.Modelo.DepartmentsEntity;


public interface DepartmentsServices {
	public abstract List<DepartmentsEntity> getDepartments();
	public abstract ResponseEntity<Object> getDepartment(int departmentId);
	public abstract void deleteDepartments (int departmentId);
	
	public abstract int save(DepartmentsEntity department);
	public Optional<DepartmentsEntity>ID(int departmentId);
	public abstract int modificar(DepartmentsEntity department);

}
