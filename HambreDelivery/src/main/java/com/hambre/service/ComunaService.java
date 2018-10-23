package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Comuna;
import com.hambre.repository.IComunaDAO;

@Service("comunaService")
public class ComunaService {
	
	@Autowired
	IComunaDAO iComunaDAO;

	public Comuna createComuna( Comuna comuna) {
		return iComunaDAO.save(comuna);
	}
	
	public Comuna updateComuna( Integer cmnId, Comuna comuna) {
		return iComunaDAO.findById(cmnId).map( comunaRes  -> {
			comunaRes.setCmnNom(comuna.getCmnNom());
			comunaRes.setCiudad(comuna.getCiudad());
			return iComunaDAO.save(comunaRes);
		}).orElseThrow(() -> new ResourceNotFoundException("Comuna id " + cmnId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdComuna( Integer cmnId ) {
		return iComunaDAO.findById(cmnId).map(comunaRes -> {
			iComunaDAO.delete(comunaRes);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Comuna id  " + cmnId  + " no existe"));
	}
	
	public Comuna getByIdComuna( Integer cmnId ) {
		return iComunaDAO.findById(cmnId).map(comunaRes -> {
            return comunaRes;
        }).orElseThrow(() -> new ResourceNotFoundException("Comuna id " + cmnId  + " no existe"));
	}
	
	public  List<Comuna> getAllComuna() {
		return iComunaDAO.findAll();
	}
}
