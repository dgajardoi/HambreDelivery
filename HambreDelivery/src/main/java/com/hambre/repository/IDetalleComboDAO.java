package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.DetalleCombo;

@Transactional
public interface IDetalleComboDAO extends JpaRepository<DetalleCombo, Integer>{

}
