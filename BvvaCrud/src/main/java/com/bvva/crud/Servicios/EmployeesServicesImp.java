package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bvva.crud.Modelo.EmployeesEntity;
import com.bvva.crud.Repositorio.EmployeesRepository;

@Service
public class EmployeesServicesImp implements EmployeesServices{

	@Autowired
	private EmployeesRepository repoEmployees;
	
	
	
	public List<EmployeesEntity> getEmployees() {
		return repoEmployees.findAll();
	}

	
	public ResponseEntity<Object> getEmployee(Integer employeeId) {
		return new ResponseEntity<>(repoEmployees.findById(employeeId), HttpStatus.OK);
	}
		
	public void deleteEmployees(Integer employeeId) {
		repoEmployees.deleteById(employeeId);
	}

	public int save(EmployeesEntity employee) {
		int res=0;
		EmployeesEntity employees = repoEmployees.save(employee);
		if (!employees.equals(null)) {
			res=1;
		}
		return 0;
	}
	
	
	@Override
	public Optional<EmployeesEntity> ID(int employeeId) {
		return repoEmployees.findById(employeeId);
	}
	
	
	@Override
	public int modificar(EmployeesEntity employee) {
		int res=0;
		Integer employeeId = employee.getEmployeeId();
		
		if(repoEmployees.findById(employeeId).isPresent()) {
			EmployeesEntity em = new EmployeesEntity();
			em.setEmployeeId(employee.getEmployeeId());
			em.setFirstName(employee.getFirstName());
			em.setLastName(employee.getLastName());
			em.setEmail(employee.getEmail());
			em.setPhoneNumber(employee.getPhoneNumber());
			em.setHireDate(employee.getHireDate());
			em.setJobId(employee.getJobId());
			em.setSalary(employee.getSalary());
			em.setCommissionPct(employee.getCommissionPct());
			em.setManagerId(employee.getManagerId());
			em.setDepartmentId(employee.getDepartmentId());	
			repoEmployees.save(em);
			res=1;
			}
			return 0;
	}
}