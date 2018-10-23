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

import com.hambre.model.TipoProducto;
import com.hambre.service.TipoProductoService;


@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class TipoProductoController {


	@Autowired
	@Qualifier("tipoProductoService")
	TipoProductoService tipoProductoService;
	
	@GetMapping("tipoProducto")
	public ResponseEntity<List<TipoProducto>> getAllTipoProducto(){
			return new ResponseEntity<>(tipoProductoService.getAllTipoProducto(),  HttpStatus.OK);
		}
	
	@GetMapping("tipoProducto/{tipPrdId}")
	public ResponseEntity<TipoProducto> getByIdTipoProducto(@PathVariable Integer tipPrdId){
			return new ResponseEntity<>(tipoProductoService.getByIdTipoProducto(tipPrdId), HttpStatus.FOUND);
		}
	
	@PutMapping("tipoProducto/{tipPrdId}")
	public ResponseEntity<TipoProducto> updateTipoProducto(@PathVariable Integer tipPrdId, @RequestBody TipoProducto tipoProducto) {
		return new ResponseEntity<>(tipoProductoService.updateTipoProducto(tipPrdId, tipoProducto), HttpStatus.OK);
	}
	
	@PostMapping("tipoProducto")
	public ResponseEntity<TipoProducto> createTipoProducto(@RequestBody TipoProducto tipoProducto) {
		return new ResponseEntity<>(tipoProductoService.createTipoProducto(tipoProducto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("tipoProducto/{tipPrdId}")
	public ResponseEntity<?> deleteTipoProducto (@PathVariable Integer tipPrdId) {
		return new ResponseEntity<>(tipoProductoService.removeByIdTipoProducto(tipPrdId), HttpStatus.OK);
	}
}
