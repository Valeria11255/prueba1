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

import com.bvva.crud.Modelo.DepartmentsEntity;
import com.bvva.crud.Modelo.LocationEntity;
import com.bvva.crud.Repositorio.DepartmentsRepository;
import com.bvva.crud.Servicios.DepartmentsServices;


@Controller
public class DepartmentsControlador {
	
	@Autowired
	private DepartmentsServices departmentsService;
	
	@Autowired
	private DepartmentsRepository departmentsRepository;
	
		
	@GetMapping("/Departments/{departmentsId}")
	public ResponseEntity<Object> getDepartment(@PathVariable int departmentsId){
		return departmentsService.getDepartment(departmentsId);
	}
	
//TABLAS
	//Mostrar
	public List<DepartmentsEntity> getDepartments(){
		return departmentsService.getDepartments();	
	}
	@GetMapping("/Departments")
	public String mostrarTabla(Model model) {
		List<DepartmentsEntity> lista = getDepartments();
		model.addAttribute("departments", lista);
		return "Departments";	
		}
			
	//Eliminar en tabla	
	@GetMapping("/DepartmentsEliminar/{departmentsId}")
	public String deleteDepartments(@PathVariable int departmentsId) {
		departmentsService.deleteDepartments(departmentsId);
		return "redirect:/Departments";
	}
	
	//Agregar
	@GetMapping("/Departmentsnew")
	 public String createDepartments(Model model) {
		model.addAttribute("departments", new DepartmentsEntity());
		return "formularioD";
		}
	
	@PostMapping("/Departmentssave")
	public String save(@Valid DepartmentsEntity department, Model model ) {
		departmentsService.save(department);
		return "redirect:/Departments";
		}
				
	//Modificar
	@GetMapping("/DepartmentsModificar/{departmentId}")
	public String editar(@PathVariable int departmentId, Model model) {
		Optional<DepartmentsEntity>departments=departmentsService.ID(departmentId);
		model.addAttribute("departments", departments);
		return "formularioDM";
		}
			
	@PostMapping("/Departmentssavem")
	public String modificar(@Valid DepartmentsEntity department, Model model ) {
		departmentsService.modificar(department);
		return "redirect:/Departments";
		}
				
	
	
	
	
}
