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

import com.hambre.model.DetalleCombo;
import com.hambre.model.DetalleProducto;
import com.hambre.service.DetalleComboService;
import com.hambre.service.DetalleProductoService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class DetalleComboController {
	@Autowired
	@Qualifier("detalleComboService")
	DetalleComboService detalleComboService;
	
	@GetMapping("detalleCombo")
	public ResponseEntity<List<DetalleCombo>> getAllDetalleProducto(){
			return new ResponseEntity<>(detalleComboService.getAllDetalleCombo(),  HttpStatus.OK);
		}
	
	@GetMapping("detalleCombo/{dtcId}")
	public ResponseEntity<DetalleCombo> getByIdDetalleProducto(@PathVariable Integer dtcId){
			return new ResponseEntity<>(detalleComboService.getByIdDetalleCombo(dtcId), HttpStatus.FOUND);
		}
	
	@PutMapping("detalleCombo/{dtcId}")
	public ResponseEntity<DetalleCombo> updateDetalleProducto(@PathVariable Integer dtcId, @RequestBody DetalleCombo detalleCombo) {
		return new ResponseEntity<>(detalleComboService.updateDetalleCombo(dtcId, detalleCombo), HttpStatus.OK);
	}
	
	@PostMapping("detalleCombo")
	public ResponseEntity<DetalleCombo> createDetalleProducto(@RequestBody DetalleCombo detalleCombo) {
		return new ResponseEntity<>(detalleComboService.createDetalleCombo(detalleCombo), HttpStatus.CREATED);
	}
	
	@DeleteMapping("detalleCombo/{dtcId}")
	public ResponseEntity<?> deleteDetalleProducto (@PathVariable Integer dtcId) {
		return new ResponseEntity<>(detalleComboService.removeByIdDetalleCombo(dtcId), HttpStatus.OK);
	}
}
