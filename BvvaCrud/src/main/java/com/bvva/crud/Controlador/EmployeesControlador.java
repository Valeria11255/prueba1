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
import com.bvva.crud.Modelo.EmployeesEntity;
import com.bvva.crud.Servicios.EmployeesServices;

@Controller
public class EmployeesControlador {
	
	@Autowired
	private EmployeesServices employeesService;
		
		
	@GetMapping("/Employees/{employeeId}")
	public ResponseEntity<Object> getEmployee(@PathVariable Integer employeeId){
		return employeesService.getEmployee(employeeId);
	}
	
	public List<EmployeesEntity> getEmployees(){
		return employeesService.getEmployees();
	}
	
	//TABLAS
	//Mostrar
	@GetMapping("/Employees")
	public String mostrarTabla(Model model) {
		List<EmployeesEntity> lista = getEmployees();
		model.addAttribute("employees", lista);
		return "Employees";
		}
	
	
	//Eliminar
	@GetMapping("/EmployeesEliminar/{employeeId}")
	public String deleteEmployees(@PathVariable Integer employeeId, Model model) {
		employeesService.deleteEmployees(employeeId);
		return "redirect:/Employees";
	}
		
	//Agregar
	@GetMapping("/Employeesnew")
	public String createEmployees(Model model) {
		model.addAttribute("employees", new EmployeesEntity());
		return "formularioE";
	}
		
	@PostMapping("/Employeessave")
	public String save(@Valid EmployeesEntity employees, Model model ) {
		employeesService.save(employees);
		return "redirect:/Employees";
	}
		
		
	//Modificar
	@GetMapping("/EmployeesModificar/{employeeId}")
	public String editar(@PathVariable Integer employeeId, Model model) {
		Optional<EmployeesEntity>employees=employeesService.ID(employeeId);
		model.addAttribute("employees", employees);
		return "formularioEM";
	}
		
	@PostMapping("/Employeessavem")
	public String modificar(@Valid EmployeesEntity employees, Model model ) {
		employeesService.modificar(employees);
		return "redirect:/Employees";
		}
}
