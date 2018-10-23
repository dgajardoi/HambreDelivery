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

import com.hambre.model.Producto;
import com.hambre.model.Venta;
import com.hambre.service.ProductoService;
import com.hambre.service.VentaService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class VentaController {

	@Autowired
	@Qualifier("ventaService")
	VentaService ventaService;
	
	@GetMapping("venta")
	public ResponseEntity<List<Venta>> getAllVenta(){
			return new ResponseEntity<>(ventaService.getAllVenta(),  HttpStatus.OK);
		}
	
	@GetMapping("venta/{venId}")
	public ResponseEntity<Venta> getByIdVenta(@PathVariable Integer venId){
			return new ResponseEntity<>(ventaService.getByIdVenta(venId), HttpStatus.FOUND);
		}
	
	@PutMapping("venta/{venId}")
	public ResponseEntity<Venta> updateVenta(@PathVariable Integer venId, @RequestBody Venta venta) {
		return new ResponseEntity<>(ventaService.updateVenta(venId, venta), HttpStatus.OK);
	}
	
	@PostMapping("venta")
	public ResponseEntity<Venta> createVenta(@RequestBody Venta venta) {
		return new ResponseEntity<>(ventaService.createVenta(venta), HttpStatus.CREATED);
	}
	
	@DeleteMapping("venta/{venId}")
	public ResponseEntity<?> deleteVenta (@PathVariable Integer venId) {
		return new ResponseEntity<>(ventaService.removeByIdVenta(venId), HttpStatus.OK);
	}
}
