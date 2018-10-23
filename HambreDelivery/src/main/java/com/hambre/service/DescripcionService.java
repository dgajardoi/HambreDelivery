package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Descripcion;
import com.hambre.repository.IDescripcionDAO;

@Service("descripcionService")
public class DescripcionService {


	@Autowired
	IDescripcionDAO iDescripcionDAO;
	
	public Descripcion createDescripcion( Descripcion descripcion) {
		return iDescripcionDAO.save(descripcion);
	}
	
	public Descripcion updateDescripcion( Integer desId, Descripcion descripcion) {
		return iDescripcionDAO.findById(desId).map(descripcionRes -> { 
			descripcionRes.setCombo(descripcion.getCombo());
			descripcionRes.setProducto(descripcion.getProducto());
			return iDescripcionDAO.save(descripcionRes);
		}).orElseThrow(() -> new ResourceNotFoundException("Descripcion id " + desId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdDescripcion(Integer desId) {
		return iDescripcionDAO.findById(desId).map(descripcionRes -> {
			iDescripcionDAO.delete(descripcionRes);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Descripcion id " + desId  +  " no se encuentra"));
	}
	
	public Descripcion getByIdDescripcion(Integer desId) {
		return iDescripcionDAO.findById(desId).map(descripcionRes -> {
            return descripcionRes;
        }).orElseThrow(() -> new ResourceNotFoundException("Descripcion id " + desId  +  " no se encuentra"));
	}
	
	public  List<Descripcion> getAllDescripcion() {
		return iDescripcionDAO.findAll();
	}
}
