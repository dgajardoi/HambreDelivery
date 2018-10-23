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

import com.hambre.model.Cliente;
import com.hambre.service.ClienteService;

@Controller
@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	@Autowired
	@Qualifier("clienteService")
	ClienteService clienteService;
	
	@GetMapping("cliente")
	public ResponseEntity<List<Cliente>> getAllCliente(){
			return new ResponseEntity<>(clienteService.getAllCliente(),  HttpStatus.OK);
		}
	
	@GetMapping("cliente/{cliId}")
	public ResponseEntity<Cliente> getByIdCliente(@PathVariable Integer cliId){
			return new ResponseEntity<>(clienteService.getByIdCliente(cliId), HttpStatus.FOUND);
		}
	
	@PutMapping("cliente/{cliId}")
	public ResponseEntity<Cliente> updateCliente(@PathVariable Integer cliId, @RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.updateCliente(cliId, cliente), HttpStatus.OK);
	}
	
	@PostMapping("cliente")
	public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
		return new ResponseEntity<>(clienteService.createCliente(cliente), HttpStatus.CREATED);
	}
	
	@DeleteMapping("cliente/{cliId}")
	public ResponseEntity<?> deleteCliente (@PathVariable Integer cliId) {
		return new ResponseEntity<>(clienteService.removeByIdCliente(cliId), HttpStatus.OK);
	}

}
