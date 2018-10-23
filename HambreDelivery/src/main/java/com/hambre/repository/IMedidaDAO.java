package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Medida;

@Transactional
public interface IMedidaDAO extends JpaRepository<Medida, Integer>{

}
