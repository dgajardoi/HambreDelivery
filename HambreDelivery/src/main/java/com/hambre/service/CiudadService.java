package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Ciudad;
import com.hambre.model.Comuna;
import com.hambre.repository.ICiudadDAO;

@Service("ciudadService")
public class CiudadService {

	@Autowired
	ICiudadDAO iCiudadDAO;
	
	public Ciudad createCiudad( Ciudad ciudad) {
		return iCiudadDAO.save(ciudad);
	}
	
	public Ciudad updateCiudad( Integer ciuId, Ciudad ciudad) {
		return iCiudadDAO.findById(ciuId).map( ciudadRes  -> {
			ciudad.setCiuNom(ciudad.getCiuNom());
			return iCiudadDAO.save(ciudadRes);
		}).orElseThrow(() -> new ResourceNotFoundException("Ciudad id " + ciuId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdCiudad( Integer ciuId ) {
		return iCiudadDAO.findById(ciuId).map(ciudadRes -> {
			iCiudadDAO.delete(ciudadRes);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Ciudad id  " + ciuId  + " no existe"));
	}
	
	public Ciudad getByIdCiudad( Integer ciuId ) {
		return iCiudadDAO.findById(ciuId).map(ciudadRes -> {
            return ciudadRes;
        }).orElseThrow(() -> new ResourceNotFoundException("Ciudad id " + ciuId  + " no existe"));
	}
	
	public  List<Ciudad> getAllCiudad() {
		return iCiudadDAO.findAll();
	}
}
