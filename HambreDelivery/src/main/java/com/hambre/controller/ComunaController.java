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
import com.hambre.model.Comuna;
import com.hambre.service.CiudadService;
import com.hambre.service.ComunaService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class ComunaController {

	@Autowired
	@Qualifier("comunaService")
	ComunaService comunaService;
	
	@GetMapping("comuna")
	public ResponseEntity<List<Comuna>> getAllComuna(){
			return new ResponseEntity<>(comunaService.getAllComuna(),  HttpStatus.OK);
		}
	
	@GetMapping("comuna/{cmnId}")
	public ResponseEntity<Comuna> getByIdComuna(@PathVariable Integer cmnId){
			return new ResponseEntity<>(comunaService.getByIdComuna(cmnId), HttpStatus.FOUND);
		}
	
	@PutMapping("comuna/{cmnId}")
	public ResponseEntity<Comuna> updateProducto(@PathVariable Integer cmnId, @RequestBody Comuna comuna) {
		return new ResponseEntity<>(comunaService.updateComuna(cmnId, comuna), HttpStatus.OK);
	}
	
	@PostMapping("comuna")
	public ResponseEntity<Comuna> createProducto(@RequestBody Comuna comuna) {
		return new ResponseEntity<>(comunaService.createComuna(comuna), HttpStatus.CREATED);
	}
	
	@DeleteMapping("comuna/{cmnId}")
	public ResponseEntity<?> deleteCiudad (@PathVariable Integer cmnId) {
		return new ResponseEntity<>(comunaService.removeByIdComuna(cmnId), HttpStatus.OK);
	}
}
