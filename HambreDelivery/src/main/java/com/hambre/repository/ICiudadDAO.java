package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Ciudad;

@Transactional
public interface ICiudadDAO extends JpaRepository<Ciudad, Integer>{

}
