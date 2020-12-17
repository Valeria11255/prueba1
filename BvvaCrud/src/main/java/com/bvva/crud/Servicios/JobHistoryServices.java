package com.bvva.crud.Servicios;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.bvva.crud.Modelo.EmployeesEntity;
import com.bvva.crud.Modelo.JobHistoryEntity;

public interface JobHistoryServices {
	
	public abstract List<JobHistoryEntity> getJobHistorys();
	public abstract ResponseEntity<Object> getJobHistory(Integer employeeId);
	public abstract void deleteJobHistory (Integer employeeId);
	
	public abstract int save(JobHistoryEntity jobHistory);
	public Optional<JobHistoryEntity>ID(int employeeId);
	public abstract int modificar(JobHistoryEntity jobHistory);
	
	
}
