package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Combo;
import com.hambre.repository.IComboDAO;

@Service("comboService")
public class ComboService {

	@Autowired
	IComboDAO iComboDAO;
	
	public Combo createCombo( Combo combo) {
		return iComboDAO.save(combo);
	}
	
	public Combo updateCombo( Integer comId, Combo combo) {
		return iComboDAO.findById(comId).map(comboRes -> { 
			comboRes.setComNom(combo.getComNom());
			comboRes.setComPrc(combo.getComPrc());
			return iComboDAO.save(comboRes);
		}).orElseThrow(() -> new ResourceNotFoundException("Combo id " + comId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdCombo(Integer comId) {
		return iComboDAO.findById(comId).map(tipProd -> {
			iComboDAO.delete(tipProd);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Combo id " + comId  +  " no se encuentra"));
	}
	
	public Combo getByIdCombo(Integer comId) {
		return iComboDAO.findById(comId).map(tipProd -> {
            return tipProd;
        }).orElseThrow(() -> new ResourceNotFoundException("Combo id " + comId  +  " no se encuentra"));
	}
	
	public  List<Combo> getAllCombo() {
		return iComboDAO.findAll();
	}
	
}
