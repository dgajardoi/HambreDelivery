package com.hambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Cliente;

public interface IClienteDAO extends JpaRepository<Cliente, Integer>{

}
