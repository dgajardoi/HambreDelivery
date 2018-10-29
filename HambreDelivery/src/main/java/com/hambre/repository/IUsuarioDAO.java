package com.hambre.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hambre.model.Cliente;
import com.hambre.model.Usuario;

@Transactional
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{
	@Query(value = "select c from Usuario c where c.usuNom=?1")
	public Optional<Usuario> findByName(String usuNom);
}
