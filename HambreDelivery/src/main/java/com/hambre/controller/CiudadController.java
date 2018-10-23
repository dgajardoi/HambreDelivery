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

import com.hambre.model.Ciudad;
import com.hambre.service.CiudadService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class CiudadController {

	@Autowired
	@Qualifier("ciudadService")
	CiudadService ciudadService;
	
	@GetMapping("ciudad")
	public ResponseEntity<List<Ciudad>> getAllCiudad(){
			return new ResponseEntity<>(ciudadService.getAllCiudad(),  HttpStatus.OK);
		}
	
	@GetMapping("ciudad/{ciuId}")
	public ResponseEntity<Ciudad> getByIdProducto(@PathVariable Integer ciuId){
			return new ResponseEntity<>(ciudadService.getByIdCiudad(ciuId), HttpStatus.FOUND);
		}
	
	@PutMapping("ciudad/{ciuId}")
	public ResponseEntity<Ciudad> updateProducto(@PathVariable Integer ciuId, @RequestBody Ciudad ciudad) {
		return new ResponseEntity<>(ciudadService.updateCiudad(ciuId, ciudad), HttpStatus.OK);
	}
	
	@PostMapping("ciudad")
	public ResponseEntity<Ciudad> createProducto(@RequestBody Ciudad ciudad) {
		return new ResponseEntity<>(ciudadService.createCiudad(ciudad), HttpStatus.CREATED);
	}
	
	@DeleteMapping("ciudad/{ciuId}")
	public ResponseEntity<?> deleteCiudad (@PathVariable Integer ciuId) {
		return new ResponseEntity<>(ciudadService.removeByIdCiudad(ciuId), HttpStatus.OK);
	}
}
