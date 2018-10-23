package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Venta;

@Transactional
public interface IVentaDAO extends JpaRepository<Venta, Integer>{

}
