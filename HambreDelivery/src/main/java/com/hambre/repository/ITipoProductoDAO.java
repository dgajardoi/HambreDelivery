package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.TipoProducto;

@Transactional
public interface ITipoProductoDAO extends JpaRepository<TipoProducto, Integer>{

}
