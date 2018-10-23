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

import com.hambre.model.DetalleProducto;
import com.hambre.service.DetalleProductoService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class DetalleProductoController {

	@Autowired
	@Qualifier("detalleProductoService")
	DetalleProductoService detalleProductoService;
	
	@GetMapping("detalleProducto")
	public ResponseEntity<List<DetalleProducto>> getAllDetalleProducto(){
			return new ResponseEntity<>(detalleProductoService.getAllDetalleProducto(),  HttpStatus.OK);
		}
	
	@GetMapping("detalleProducto/{dtpPrdId}")
	public ResponseEntity<DetalleProducto> getByIdDetalleProducto(@PathVariable Integer dtpPrdId){
			return new ResponseEntity<>(detalleProductoService.getByIdDetalleProducto(dtpPrdId), HttpStatus.FOUND);
		}
	
	@PutMapping("detalleProducto/{dtpPrdId}")
	public ResponseEntity<DetalleProducto> updateDetalleProducto(@PathVariable Integer dtpPrdId, @RequestBody DetalleProducto detalleProducto) {
		return new ResponseEntity<>(detalleProductoService.updateDetalleProducto(dtpPrdId, detalleProducto), HttpStatus.OK);
	}
	
	@PostMapping("detalleProducto")
	public ResponseEntity<DetalleProducto> createDetalleProducto(@RequestBody DetalleProducto detalleProducto) {
		return new ResponseEntity<>(detalleProductoService.createDetalleProducto(detalleProducto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("detalleProducto/{dtpPrdId}")
	public ResponseEntity<?> deleteDetalleProducto (@PathVariable Integer dtpPrdId) {
		return new ResponseEntity<>(detalleProductoService.removeByIdDetalleProducto(dtpPrdId), HttpStatus.OK);
	}
}
