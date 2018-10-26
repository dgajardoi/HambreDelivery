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

import com.hambre.model.Descripcion;
import com.hambre.service.DescripcionService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class DescripcionController {

	@Autowired
	@Qualifier("descripcionService")
	DescripcionService descripcionService;
	
	@GetMapping("descripciones/listar")
	public ResponseEntity<List<Descripcion>> getAllDescripcion(){
			return new ResponseEntity<>(descripcionService.getAllDescripcion(),  HttpStatus.OK);
		}
	
	@GetMapping("descripciones/{desId}/datos")
	public ResponseEntity<Descripcion> getByIdDescripcion(@PathVariable Integer desId){
			return new ResponseEntity<>(descripcionService.getByIdDescripcion(desId), HttpStatus.FOUND);
		}
	
	@PutMapping("descripciones/{desId}/editar")
	public ResponseEntity<Descripcion> updateDescripcion(@PathVariable Integer desId, @RequestBody Descripcion descripcion) {
		return new ResponseEntity<>(descripcionService.updateDescripcion(desId, descripcion), HttpStatus.OK);
	}
	
	@PostMapping("descripcion/crear")
	public ResponseEntity<Descripcion> createDescripcion(@RequestBody Descripcion descripcion) {
		return new ResponseEntity<>(descripcionService.createDescripcion(descripcion), HttpStatus.CREATED);
	}
	
	@DeleteMapping("descripciones/{desId}/eliminar")
	public ResponseEntity<?> deleteDescripcion (@PathVariable Integer desId) {
		return new ResponseEntity<>(descripcionService.removeByIdDescripcion(desId), HttpStatus.OK);
	}
}
