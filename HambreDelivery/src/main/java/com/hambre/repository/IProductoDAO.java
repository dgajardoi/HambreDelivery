package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Producto;

@Transactional
public interface IProductoDAO extends JpaRepository<Producto, Integer>{

}
