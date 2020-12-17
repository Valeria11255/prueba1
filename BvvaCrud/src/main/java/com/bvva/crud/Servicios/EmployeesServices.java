package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import com.bvva.crud.Modelo.EmployeesEntity;

public interface EmployeesServices {
	public abstract List<EmployeesEntity> getEmployees();
	public abstract ResponseEntity<Object> getEmployee(Integer employeeId);
	public abstract void deleteEmployees (Integer employeeId);
	
	public abstract int save(EmployeesEntity employee);
	public Optional<EmployeesEntity>ID(int employeeId);
	public abstract int modificar(EmployeesEntity employee);
	

}
