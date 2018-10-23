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

import com.hambre.model.TipoUsuario;
import com.hambre.service.TipoUsuarioService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class TipoUsuarioController {

	@Autowired
	@Qualifier("tipoUsuarioService")
	TipoUsuarioService tipoUsuarioService;
	
	@GetMapping("tipoUsuario")
	public ResponseEntity<List<TipoUsuario>> getAllTipoUsuario(){
			return new ResponseEntity<>(tipoUsuarioService.getAllTipoUsuario(),  HttpStatus.OK);
		}
	
	@GetMapping("tipoUsuario/{tipUsuId}")
	public ResponseEntity<TipoUsuario> getByIdTipoUsuario(@PathVariable Integer tipUsuId){
			return new ResponseEntity<>(tipoUsuarioService.getByIdTipoUsuario(tipUsuId), HttpStatus.FOUND);
		}
	
	@PutMapping("tipoUsuario")
	public ResponseEntity<TipoUsuario> updateTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return new ResponseEntity<>(tipoUsuarioService.updateTipoUsuario(tipoUsuario), HttpStatus.OK);
	}
	
	@PostMapping("tipoUsuario")
	public ResponseEntity<TipoUsuario> createTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
		return new ResponseEntity<>(tipoUsuarioService.createTipoUsuario(tipoUsuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping("tipoUsuario/{tipUsuId}")
	public ResponseEntity<?> deleteTipoUsuario (@PathVariable Integer tipUsuId) {
		return new ResponseEntity<>(tipoUsuarioService.removeTipoUsuarioId(tipUsuId), HttpStatus.OK);
	}
}
