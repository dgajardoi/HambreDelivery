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
import org.springframework.web.bind.annotation.RequestMethod;

import com.hambre.model.Cliente;
import com.hambre.service.ClienteService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	@Autowired
	@Qualifier("clienteService")
	ClienteService clienteService;
	
	@GetMapping(value = "clientes/listar")
	public ResponseEntity<List<Cliente>> getAllCliente(){
			return new ResponseEntity<>(clienteService.getAllCliente(),  HttpStatus.OK);
		}
	
	@GetMapping(value = "cliente/telofono/{cliTel}/datos")
	public ResponseEntity<Cliente> getTelefonoCliente(@PathVariable String cliTel){
			return new ResponseEntity<>(clienteService.getTelefonoPorCliente(cliTel),  HttpStatus.OK);
		}
	
	@GetMapping(value = "clientes/{cliId}/datos")
	public ResponseEntity<Cliente> getByIdCliente(@PathVariable Integer cliId){
			return new ResponseEntity<>(clienteService.getByIdCliente(cliId), HttpStatus.FOUND);
		}
	
	@PutMapping(value = "clientes/{cliId}/editar")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Integer cliId, @RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.updateCliente(cliId, cliente), HttpStatus.OK);
	}
	
	@PostMapping(value = "cliente/crear")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.createCliente(cliente), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "clientes/{cliId}/eliminar")
	public ResponseEntity<?> deleteCliente (@PathVariable Integer cliId) {
		return new ResponseEntity<>(clienteService.removeByIdCliente(cliId), HttpStatus.OK);
	}

}
