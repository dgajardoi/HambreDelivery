package com.hambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Comuna;

public interface IComunaDAO extends JpaRepository<Comuna, Integer>{

}
