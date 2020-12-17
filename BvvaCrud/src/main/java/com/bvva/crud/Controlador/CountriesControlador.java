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
import com.bvva.crud.Modelo.CountriesEntity;
import com.bvva.crud.Repositorio.CountriesRepository;
import com.bvva.crud.Servicios.CountriesServices;


@Controller
public class CountriesControlador {
	@Autowired
	private CountriesServices countriesService;

	
	
    //buscar por id
	@GetMapping("/Countries/{countryId}")
	public ResponseEntity<Object> getCountry(@PathVariable String countryId){
		return countriesService.getCountry(countryId);
	}

	//TABLAS
	//Mostrar
	public List<CountriesEntity> getCountries(){
		return countriesService.getCountries();	
	}
	@GetMapping("/Countries")
	public String mostrarTabla(Model model) {
		List<CountriesEntity> lista = getCountries();
		model.addAttribute("countries", lista);
		return "Countries";
	}
		
	@GetMapping("/CountriesEliminar/{countryId}")
	public String deleteCountry(@PathVariable String countryId, Model model) {
		countriesService.deleteCountry(countryId);
		return "redirect:/Countries";
	}
		
	//Agregar
	@GetMapping("/Countriesnew")
	 public String createJobs(Model model) {
		model.addAttribute("countries", new CountriesEntity());
		return "formularioC";
	}
	
	@PostMapping("/Countriessave")
	public String save(@Valid CountriesEntity countries, Model model ) {
		countriesService.save(countries);
		return "redirect:/Countries";
	}
	
	
	//Modificar
	@GetMapping("/CountriesModificar/{countryId}")
	public String editar(@PathVariable String countryId, Model model) {
		Optional<CountriesEntity>countries=countriesService.ID(countryId);
		model.addAttribute("countries", countries);
		return "formularioCM";
	}
	
	@PostMapping("/Countriessavem")
	public String modificar(@Valid CountriesEntity countries, Model model ) {
		countriesService.modificar(countries);
		return "redirect:/Countries";
	}
		
}
