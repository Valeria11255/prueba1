package com.bvva.crud.Servicios;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.bvva.crud.Modelo.JobsEntity;


public interface JobsServices {
	public abstract List<JobsEntity> getJobs();
	public abstract ResponseEntity<Object> getJob(String jobId);
	public abstract void deleteJobs (String jobId);
	
	public abstract int save(JobsEntity jobs);
	public Optional<JobsEntity>ID(String jobId);
	public abstract int modificar(JobsEntity jobs);

}
