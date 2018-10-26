package com.hambre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hambre.model.Ciudad;
import com.hambre.service.CiudadService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class CiudadController {

	@Autowired
	@Qualifier("ciudadService")
	CiudadService ciudadService;
	
	@GetMapping(value = "ciudades/listar")
	public ResponseEntity<List<Ciudad>> getAllCiudad(){
			return new ResponseEntity<>(ciudadService.getAllCiudad(),  HttpStatus.OK);
		}
	
	
	@GetMapping(value = "ciudades/{ciuId}/datos")
	public ResponseEntity<Ciudad> getByIdCiudad(@PathVariable Integer ciuId){
			return new ResponseEntity<>(ciudadService.getByIdCiudad(ciuId), HttpStatus.FOUND);
		}
	
	@PutMapping(value = "ciudades/{ciuId}/editar")
	public ResponseEntity<Ciudad> updateCiudad(@PathVariable Integer ciuId, @RequestBody Ciudad ciudad) {
		return new ResponseEntity<>(ciudadService.updateCiudad(ciuId, ciudad), HttpStatus.OK);
	}
	
	@PostMapping(value = "ciudad/crear")
	public ResponseEntity<Ciudad> createCiudad(@RequestBody Ciudad ciudad) {
		return new ResponseEntity<>(ciudadService.createCiudad(ciudad), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "ciudades/{ciuId}/eliminar")
	public ResponseEntity<?> deleteCiudad (@PathVariable Integer ciuId) {
		return new ResponseEntity<>(ciudadService.removeByIdCiudad(ciuId), HttpStatus.OK);
	}
}
