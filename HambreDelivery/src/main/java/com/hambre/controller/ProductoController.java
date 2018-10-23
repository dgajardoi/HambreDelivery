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
import com.hambre.service.ProductoService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class ProductoController {

	@Autowired
	@Qualifier("productoService")
	ProductoService productoService;
	
	@GetMapping("producto")
	public ResponseEntity<List<Producto>> getAllProducto(){
			return new ResponseEntity<>(productoService.getAllProducto(),  HttpStatus.OK);
		}
	
	@GetMapping("producto/{prdId}")
	public ResponseEntity<Producto> getByIdProducto(@PathVariable Integer prdId){
			return new ResponseEntity<>(productoService.getByIdProducto(prdId), HttpStatus.FOUND);
		}
	
	@PutMapping("producto/{prdId}")
	public ResponseEntity<Producto> updateProducto(@PathVariable Integer prdId, @RequestBody Producto producto) {
		return new ResponseEntity<>(productoService.updateProducto(prdId, producto), HttpStatus.OK);
	}
	
	@PostMapping("producto")
	public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {
		return new ResponseEntity<>(productoService.createProducto(producto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("producto/{prdId}")
	public ResponseEntity<?> deleteProducto (@PathVariable Integer prdId) {
		return new ResponseEntity<>(productoService.removeByIdProducto(prdId), HttpStatus.OK);
	}
}
