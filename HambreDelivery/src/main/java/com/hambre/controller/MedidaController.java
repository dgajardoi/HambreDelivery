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

import com.hambre.model.Medida;
import com.hambre.service.MedidaService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class MedidaController {
	
	@Autowired
	@Qualifier("medidaService")
	MedidaService medidaService;
	
	@GetMapping("medidas/listar")
	public ResponseEntity<List<Medida>> getAllMedida(){
			return new ResponseEntity<>(medidaService.getAllMedida(),  HttpStatus.OK);
		}
	
	@GetMapping("medidas/{medId}/datos")
	public ResponseEntity<Medida> getByIdMedida(@PathVariable Integer medId){
			return new ResponseEntity<>(medidaService.getByIdMedida(medId), HttpStatus.FOUND);
		}
	
	@PutMapping("medidas/{medId}/editar")
	public ResponseEntity<Medida> updateMedida(@PathVariable Integer medId, @RequestBody Medida medida) {
		return new ResponseEntity<>(medidaService.updateMedida(medId, medida), HttpStatus.OK);
	}
	
	@PostMapping("medida/crear")
	public ResponseEntity<Medida> createMedida(@RequestBody Medida medida) {
		return new ResponseEntity<>(medidaService.createMedida(medida), HttpStatus.CREATED);
	}
	
	@DeleteMapping("medidas/{medId}/eliminar")
	public ResponseEntity<?> deleteMedida (@PathVariable Integer medId) {
		return new ResponseEntity<>(medidaService.removeByIdMedida(medId), HttpStatus.OK);
	}
}
