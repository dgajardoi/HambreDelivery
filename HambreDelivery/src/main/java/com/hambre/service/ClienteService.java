package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Cliente;
import com.hambre.repository.IClienteDAO;

@Service("clienteService")
public class ClienteService {

	@Autowired
	IClienteDAO iClienteDAO;
	
	public Cliente createCliente( Cliente cliente) {
		return iClienteDAO.save(cliente);
	}
	
	public Cliente updateCliente( Integer cliId, Cliente cliente) {
		return iClienteDAO.findById(cliId).map( cli  -> {
			cli.setCliNom(cliente.getCliNom());
			cli.setCliDir(cliente.getCliDir());
			cli.setCliTel(cliente.getCliTel());
			return iClienteDAO.save(cli);
		}).orElseThrow(() -> new ResourceNotFoundException("El id " + cliId  + " de cliente no existe"));
	}
	
	public ResponseEntity<?> removeByIdCliente(Integer cliId) {
		return iClienteDAO.findById(cliId).map(cliente -> {
			iClienteDAO.delete(cliente);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Cliente Id " + cliId + " no se encuentra"));
	}
	
	public Cliente getByIdCliente(Integer cliId) {
		return iClienteDAO.findById(cliId).map(cliente -> {
            return cliente;
        }).orElseThrow(() -> new ResourceNotFoundException("Cliente Id " + cliId + " no se encuentra"));
	}
	
	public  List<Cliente> getAllCliente() {
		return iClienteDAO.findAll();
	}
}
