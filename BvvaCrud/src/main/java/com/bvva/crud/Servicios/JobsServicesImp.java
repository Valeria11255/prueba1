package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bvva.crud.Modelo.JobsEntity;
import com.bvva.crud.Modelo.RegionsEntity;
import com.bvva.crud.Repositorio.JobsRepository;

@Service
public class JobsServicesImp implements JobsServices{
	
	@Autowired
	private JobsRepository repoJobs;
	
	public List<JobsEntity> getJobs() {
		return repoJobs.findAll();
	}
	
	public ResponseEntity<Object> getJob(String jobId) {
		return new ResponseEntity<>(repoJobs.findById(jobId), HttpStatus.OK);
	}

	public void deleteJobs(String jobId) {
		repoJobs.deleteById(jobId);
		}

	@Override
	public int save(JobsEntity jobs) {
		int res=0;
		JobsEntity jobss = repoJobs.save(jobs);
		if(!jobss.equals(null)){
			res= 1;
		}
		return 0;
	}
	
	@Override
	public Optional<JobsEntity>ID(String jobId) {
		return repoJobs.findById(jobId);
	}

	@Override
	public int modificar(JobsEntity jobs) {
		int res=0;
		String jobId = jobs.getJobId();
		if(repoJobs.findById(jobId).isPresent()) {
			JobsEntity j = new JobsEntity();
			j.setJobId(jobs.getJobId());
			j.setJobTitle(jobs.getJobTitle());
			j.setMinSalary(jobs.getMinSalary());
			j.setMaxSalary(jobs.getMaxSalary());
			repoJobs.save(j);
			res=1;
	}
		return 0;
	}
}
