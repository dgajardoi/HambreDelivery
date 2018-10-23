package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.TipoProducto;
import com.hambre.repository.ITipoProductoDAO;

@Service("tipoProductoService")
public class TipoProductoService {

	@Autowired
	ITipoProductoDAO iTipoProductoDAO;
	
	public TipoProducto createTipoProducto( TipoProducto tipoProducto) {
		return iTipoProductoDAO.save(tipoProducto);
	}
	
	public TipoProducto updateTipoProducto( Integer tipPrdId, TipoProducto tipoProducto) {
		return iTipoProductoDAO.findById(tipPrdId).map( tipProd  -> {
			tipProd.setTipPrdNom(tipoProducto.getTipPrdNom());
			//tipProd.setProducto(tipoProducto.getProducto());
			return iTipoProductoDAO.save(tipProd);
		}).orElseThrow(() -> new ResourceNotFoundException("Tipo de producto id " + tipPrdId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdTipoProducto(Integer tipPrdId) {
		return iTipoProductoDAO.findById(tipPrdId).map(tipProd -> {
			iTipoProductoDAO.delete(tipProd);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Tipo de producto id " + tipPrdId  +  " no se encuentra"));
	}
	
	public TipoProducto getByIdTipoProducto(Integer tipPrdId) {
		return iTipoProductoDAO.findById(tipPrdId).map(tipProd -> {
            return tipProd;
        }).orElseThrow(() -> new ResourceNotFoundException("Tipo de producto id " + tipPrdId  +  " no se encuentra"));
	}
	
	public  List<TipoProducto> getAllTipoProducto() {
		return iTipoProductoDAO.findAll();
	}
}
