package com.bvva.crud.Servicios;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bvva.crud.Modelo.JobHistoryEntity;
import com.bvva.crud.Repositorio.JobHistoryRepository;

@Service
public class JobHistoryServicesImp implements JobHistoryServices{

	@Autowired
	private JobHistoryRepository repoJobHistory;

	@Override
	public List<JobHistoryEntity> getJobHistorys() {
		return repoJobHistory.findAll();
	}

	@Override
	public ResponseEntity<Object> getJobHistory(Integer employeeId) {
		return new ResponseEntity<>(repoJobHistory.findById(employeeId), HttpStatus.OK);
	}

	@Override
	public void deleteJobHistory(Integer employeeId) {
		repoJobHistory.deleteById(employeeId);
	}

	@Override
	public int save(JobHistoryEntity jobHistory) {
		int res=0;
		JobHistoryEntity jobHistorys = repoJobHistory.save(jobHistory);
		if (!jobHistorys.equals(null)) {
			res=1;
		}
		return 0;
	}

	@Override
	public Optional<JobHistoryEntity> ID(int employeeId) {
		return repoJobHistory.findById(employeeId);
	}

	@Override
	public int modificar(JobHistoryEntity jobHistory) {
		int res=0;
		Integer employeeId = jobHistory.getEmployeeId();
		
		if (repoJobHistory.findById(employeeId).isPresent()) {
			JobHistoryEntity jh = new JobHistoryEntity();
			jh.setEmployeeId(jobHistory.getEmployeeId());
			jh.setStartDate(jobHistory.getStartDate());
			jh.setEndDate(jobHistory.getEndDate());
			jh.setJobId(jobHistory.getJobId());
			jh.setDepartmentId(jobHistory.getDepartmentId());
			repoJobHistory.save(jh);
			res=1;
		}
		return 0;
	}
}
