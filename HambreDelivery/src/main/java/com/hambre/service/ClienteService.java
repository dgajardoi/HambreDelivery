package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.dto.ClienteDTO;
import com.hambre.model.Cliente;
import com.hambre.repository.IClienteDAO;

@Service("clienteService")
public class ClienteService {

	@Autowired
	IClienteDAO iClienteDAO;
	
	/*public Cliente createCliente( Cliente cliente) {
		return iClienteDAO.save(cliente);
	}*/
	
	public ClienteDTO createCliente( ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setCliTel(clienteDTO.getTelefono());
		cliente.setCliNom(clienteDTO.getNombre());
		cliente.setCliDir(clienteDTO.getDireccion());
		cliente.getComuna().setCmnId(clienteDTO.getComunaId());
		cliente = iClienteDAO.save(cliente);
		if(cliente != null)
			return clienteDTO;
		return null;
	}

	public ClienteDTO getTelefonoPorCliente( String  cliTel) {
		Cliente cli = iClienteDAO.getTelefonoPorCliente(cliTel);
		ClienteDTO clienteDTO = new ClienteDTO();
		if( cli != null) {
			clienteDTO.setTelefono(cli.getCliTel());
			clienteDTO.setNombre(cli.getCliNom());
			clienteDTO.setDireccion(cli.getCliDir());
			clienteDTO.setComunaId(cli.getComuna().getCmnId());
			return clienteDTO;
		}
		return null;
	}
	
	public Cliente updateCliente( Integer cliId, Cliente cliente) {
		return iClienteDAO.findById(cliId).map( cli  -> {
			cli.setCliNom(cliente.getCliNom());
			cli.setCliDir(cliente.getCliDir());
			cli.setCliTel(cliente.getCliTel());
			cli.setComuna(cliente.getComuna());
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
