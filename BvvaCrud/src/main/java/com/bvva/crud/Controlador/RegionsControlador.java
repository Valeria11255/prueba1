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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvva.crud.Modelo.CountriesEntity;
import com.bvva.crud.Modelo.RegionsEntity;
import com.bvva.crud.Servicios.RegionsServices;


//@RestController
@Controller
public class RegionsControlador {
	
	@Autowired
	private RegionsServices regionsService;
	
	
//MOSTRAR EN JSON
	@GetMapping("/r")
	public List<RegionsEntity> getRegions(){
		return regionsService.getRegions();
	}

	@GetMapping("/Regions/{regionId}")
	public ResponseEntity<Object> getRegion(@PathVariable Integer regionId){
		System.out.print(regionsService.getRegion(regionId));
		return regionsService.getRegion(regionId);
	}
	

	
	
//TABLAS
//MOSTRAR TABLA DE REGIONES
	@GetMapping("/Regions")
	public String mostrarTabla(Model model) {
		List<RegionsEntity> lista = getRegions();
		model.addAttribute("regiones", lista);
		return "Regions";
		}
	
	//Eliminar en tabla
	@GetMapping("/Eliminar/{regionId}")
	public String deleteRegions(@PathVariable Integer regionId, Model model) {
		regionsService.deleteRegions(regionId);
		return "redirect:/Regions";		
		}
	
	//Agregar
	@GetMapping("/new")
	 public String createRegions(Model model) {
		model.addAttribute("regiones", new RegionsEntity());
		return "formularioR";
	}
	
	@PostMapping("/save")
	public String save(@Valid RegionsEntity region, Model model ) {
		regionsService.save(region);
		return "redirect:/Regions";
	}
	
	
	//Modificar
	@GetMapping("/Modificar/{regionId}")
	public String editar(@PathVariable int regionId, Model model) {
		Optional<RegionsEntity>regiones=regionsService.ID(regionId);
		model.addAttribute("regiones", regiones);
		return "formularioRM";
	}
	
	@PostMapping("/savem")
	public String modificar(@Valid RegionsEntity region, Model model ) {
		regionsService.modificar(region);
		return "redirect:/Regions";
	}
	

	
	
	
/* consulta
	@GetMapping("/Regiones")
	public List<RegionsEntity> findDescriptionEmp() {
		return regionsService.findDescriptionEmp();
		
	}
*/	
	
	
	
}
