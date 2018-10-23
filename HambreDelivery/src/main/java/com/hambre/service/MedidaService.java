package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Medida;
import com.hambre.repository.IMedidaDAO;

@Service("medidaService")
public class MedidaService {

	@Autowired
	IMedidaDAO iMedidaDAO;
	
	public Medida createMedida( Medida medida) {
		return iMedidaDAO.save(medida);
	}
	
	public Medida updateMedida( Integer medId, Medida medida) {
		return iMedidaDAO.findById(medId).map( medidaRes  -> {
			medidaRes.setMedNom(medida.getMedNom());
			//medidaRes.setProducto(medida.getProducto());
			return iMedidaDAO.save(medidaRes);
		}).orElseThrow(() -> new ResourceNotFoundException("Medida id " + medId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdMedida(Integer medId) {
		return iMedidaDAO.findById(medId).map(medidaRes -> {
			iMedidaDAO.delete(medidaRes);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Medida id " + medId  + " no se encuentra"));
	}
	
	public Medida getByIdMedida(Integer medId) {
		return iMedidaDAO.findById(medId).map(medidaRes -> {
            return medidaRes;
        }).orElseThrow(() -> new ResourceNotFoundException("Medida id " + medId  + " no se encuentra"));
	}
	
	public  List<Medida> getAllMedida() {
		return iMedidaDAO.findAll();
	}
}
