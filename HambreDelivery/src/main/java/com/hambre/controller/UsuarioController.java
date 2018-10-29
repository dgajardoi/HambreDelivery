package com.hambre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hambre.dto.UserDTO;
import com.hambre.model.TipoUsuario;
import com.hambre.model.Usuario;
import com.hambre.service.TipoUsuarioService;
import com.hambre.service.UsuarioService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class UsuarioController {
	
	@Autowired
	@Qualifier("usuarioService")
	UsuarioService usuarioService;
	
	@PreAuthorize("hasAnyRole('ROLE_Administrador')")
	@GetMapping("usuarios/listar")
	public ResponseEntity<List<Usuario>> getAllUsuario(){
			return  new ResponseEntity<> ( usuarioService.getAllTipoUsuario(),  HttpStatus.OK);
		}
	
	@GetMapping("usuarios/{tipUsuId}/datos")
	public ResponseEntity<Usuario> getByIdUsuario(@PathVariable Integer tipUsuId){
			return new ResponseEntity<>( usuarioService.getByIdUsuario(tipUsuId), HttpStatus.FOUND);
		}
	
	
	@PutMapping("usuarios/editar")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario) {
		return new ResponseEntity<>( usuarioService.updateUsuario(usuario), HttpStatus.OK);
	}
	
	
	@PostMapping("usuario/crear")
	public ResponseEntity<UserDTO> createUsuario(@RequestBody UserDTO usuario) {
		return new ResponseEntity<>( usuarioService.createUsuario(usuario), HttpStatus.CREATED);
	}
	
	@DeleteMapping("usuarios/{tipUsuId}/eliminar")
	public ResponseEntity<?> deleteTipoUsuario (@PathVariable Integer tipUsuId) {
		return new ResponseEntity<>( usuarioService.removeUsuarioId(tipUsuId),  HttpStatus.OK);
	}
}