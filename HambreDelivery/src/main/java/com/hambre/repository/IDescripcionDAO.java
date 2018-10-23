package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Descripcion;

@Transactional
public interface IDescripcionDAO extends JpaRepository<Descripcion, Integer>{

}
