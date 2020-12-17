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
import com.bvva.crud.Modelo.LocationEntity;
import com.bvva.crud.Servicios.LocationServices;

@Controller
public class LocationControlador {
	
	@Autowired
	private LocationServices locationService;
	
	@GetMapping("/Location/{locationId}")
	public ResponseEntity<Object> getLocation(@PathVariable Integer locationId){
		return locationService.getLocation(locationId);
	}
	//TABLAS
	//Mostrar
	public List<LocationEntity> getLocations(){
		return locationService.getLocations();	
	}
		
	@GetMapping("/Location")
	public String mostrarTabla(Model model) {
		List<LocationEntity> lista = getLocations();
		model.addAttribute("locations", lista);
		return "Location";
	}
		
//Eliminar en tabla
	@GetMapping("/LocationEliminar/{locationId}")
	public String deleteLocation(@PathVariable Integer locationId, Model model) {
		locationService.deleteLocation(locationId);
		return "redirect:/Location";		
		}
		
	//Agregar
	@GetMapping("/Locationnew")
	public String createLocations(Model model) {
		model.addAttribute("locations", new LocationEntity());
		return "formularioL";
		}
		
	@PostMapping("/Locationsave")
	public String save(@Valid LocationEntity location, Model model ) {
		locationService.save(location);
		return "redirect:/Location";
		}
			
	//Modificar
	@GetMapping("/LocationModificar/{locationId}")
	public String editar(@PathVariable int locationId, Model model) {
		Optional<LocationEntity>locations=locationService.ID(locationId);
		model.addAttribute("locations", locations);
		return "formularioLM";
		}
		
	@PostMapping("/Locationsavem")
	public String modificar(@Valid LocationEntity location, Model model ) {
		locationService.modificar(location);
		return "redirect:/Location";
		}
		
}
