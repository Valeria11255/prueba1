package com.bvva.crud.Controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bvva.crud.Modelo.JobsEntity;
import com.bvva.crud.Servicios.JobsServices;

@Controller
public class JobsControlador {
	@Autowired
	private JobsServices jobsService;

	@GetMapping("/Jobs/{jobId}")
	public ResponseEntity<Object> getJob(@PathVariable String jobId){
		return jobsService.getJob(jobId);
	}

//TABLAS
//Mostrar
	public List<JobsEntity> getJobs(){
		return jobsService.getJobs();	
	}
	@GetMapping("/Jobs")
	public String mostrarTabla(Model model) {
		List<JobsEntity> lista = getJobs();
		model.addAttribute("jobs", lista);
		return "Jobs";
		}
	
	//Eliminar en tabla
	@GetMapping("/JobsEliminar/{jobId}")
	public String deleteJobs(@PathVariable String jobId, Model model) {
		jobsService.deleteJobs(jobId);
		return "redirect:/Jobs";		
		}
	
	//Agregar
	@GetMapping("/Jobsnew")
	 public String createJobs(Model model) {
		model.addAttribute("jobs", new JobsEntity());
		return "formularioJ";
	}
	
	@PostMapping("/Jobssave")
	public String save(@Valid JobsEntity jobs, Model model ) {
		jobsService.save(jobs);
		return "redirect:/Jobs";
	}
	
	
	//Modificar
	@GetMapping("/JobsModificar/{jobId}")
	public String editar(@PathVariable String jobId, Model model) {
		Optional<JobsEntity>jobs=jobsService.ID(jobId);
		model.addAttribute("jobs", jobs);
		return "formularioJM";
	}
	
	@PostMapping("/Jobssavem")
	public String modificar(@Valid JobsEntity jobs, Model model ) {
		jobsService.modificar(jobs);
		return "redirect:/Jobs";
	}
	
}
