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
import com.bvva.crud.Modelo.JobHistoryEntity;
import com.bvva.crud.Repositorio.JobHistoryRepository;
import com.bvva.crud.Servicios.JobHistoryServices;


@Controller
public class JobHistoryControlador {
	
	
	@Autowired
	private JobHistoryServices jobHistoryService;
	
	
	@Autowired
	private JobHistoryRepository jbRepository;
	
	@GetMapping("/JobHistorys/{employeeId}")
	public ResponseEntity<Object> getJobHistory(@PathVariable Integer employeeId){
			return jobHistoryService.getJobHistory(employeeId);
	}


//TABLAS
//Mostrar
	public List<JobHistoryEntity> getJobHistorys(){
		return jobHistoryService.getJobHistorys();
	}
    @GetMapping("/JobsHistory")
	public String mostrarTabla(Model model) {
    	List<JobHistoryEntity> lista = getJobHistorys();
		model.addAttribute("jobHistory", lista);
		return "JobHistory";
		}
	
	@GetMapping("/JobHistoryEliminar/{employeeId}")
	public String deleteJobHistory(@PathVariable Integer employeeId) {
		jobHistoryService.deleteJobHistory(employeeId);
		return "redirect:/JobHistory";
	}	
	
//Agregar
	@GetMapping("/JobHistorynew")
	public String createJobHistory(Model model) {
		model.addAttribute("jobHistory", new JobHistoryEntity());
		return "formularioJH";
		}
			
	@PostMapping("/JobHistorysave")
	public String save(@Valid JobHistoryEntity jobHistory, Model model ) {
		jobHistoryService.save(jobHistory);
		return "redirect:/JobsHistory";
		}
			
	//Modificar
	@GetMapping("/JobHistoryModificar/{employeeId}")
	public String editar(@PathVariable Integer employeeId, Model model) {
		Optional<JobHistoryEntity>jobHistory=jobHistoryService.ID(employeeId);
		model.addAttribute("jobHistory", jobHistory);
		return "formularioJHM";
		}
			
	@PostMapping("/JobHistorysavem")
	public String modificar(@Valid JobHistoryEntity jobHistory, Model model ) {
		jobHistoryService.modificar(jobHistory);
		return "redirect:/JobHistory";
		}
		
	
	
}
