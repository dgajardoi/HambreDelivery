package com.hambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.DetalleProducto;

public interface IDetalleProductoDAO extends JpaRepository<DetalleProducto, Integer>{

}
