package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.TipoUsuario;

@Transactional
public interface ITipoUsuarioDao extends JpaRepository<TipoUsuario, Integer> {

}
