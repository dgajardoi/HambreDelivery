package com.hambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hambre.model.Cliente;

public interface IClienteDAO extends JpaRepository<Cliente, Integer>{
	
	@Query(value = "select c from Cliente c where c.cliTel=?1")
	public Cliente getTelefonoPorCliente(String cliTel);

}
