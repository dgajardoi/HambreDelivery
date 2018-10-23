package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Usuario;

@Transactional
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{

}
