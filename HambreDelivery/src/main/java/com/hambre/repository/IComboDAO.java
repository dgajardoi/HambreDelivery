package com.hambre.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hambre.model.Combo;

@Transactional
public interface IComboDAO extends JpaRepository< Combo, Integer>{

}
