package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bvva.crud.Modelo.DepartmentsEntity;
import com.bvva.crud.Repositorio.DepartmentsRepository;

@Service
public class DepartmentsServicesImp implements DepartmentsServices {

	@Autowired
	private DepartmentsRepository repoDepartments;

	public List<DepartmentsEntity> getDepartments() {
		return repoDepartments.findAll();
	}

	public ResponseEntity<Object> getDepartment(int departmentId) {
		return new ResponseEntity<>(repoDepartments.findById(departmentId), HttpStatus.OK);
	}

	public void deleteDepartments(int departmentId) {
		repoDepartments.deleteById(departmentId);
	}

	@Override
	public int save(DepartmentsEntity department) {
		int res=0;
		DepartmentsEntity departments = repoDepartments.save(department);
		if (!departments.equals(null)) {
			return 1;
		}
		return 0;
	}

	@Override
	public Optional<DepartmentsEntity> ID(int departmentId) {
		return repoDepartments.findById(departmentId);
	}

	@Override
	public int modificar(DepartmentsEntity department) {
		int res=0;
		int departmentId =department.getDepartmentId();
		if(repoDepartments.findById(departmentId).isPresent()) {
			DepartmentsEntity d = new DepartmentsEntity();
			d.setDepartmentId(department.getDepartmentId());
			d.setDepartmentName(department.getDepartmentName());
			d.setManagerId(department.getManagerId());
			d.setLocationId(department.getLocationId());
			repoDepartments.save(d);
			return 1;
		}
		return 0;
	}

}
