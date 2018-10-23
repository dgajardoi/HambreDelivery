package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.DetalleCombo;
import com.hambre.repository.IDetalleComboDAO;

@Service("detalleComboService")
public class DetalleComboService {
	@Autowired
	IDetalleComboDAO iDetalleComboDAO;
	
	public DetalleCombo createDetalleCombo( DetalleCombo detalleCombo) {
		return iDetalleComboDAO.save(detalleCombo);
	}
	
	public DetalleCombo updateDetalleCombo( Integer dtcId, DetalleCombo detalleCombo) {
		return iDetalleComboDAO.findById(dtcId).map( detalleComboRes  -> {
			detalleComboRes.setDtcPrc(detalleCombo.getDtcPrc());
			detalleComboRes.setDtcCan(detalleCombo.getDtcCan());
			detalleComboRes.setVenta(detalleCombo.getVenta());
			detalleComboRes.setCombo(detalleCombo.getCombo());
			return iDetalleComboDAO.save(detalleComboRes);
		}).orElseThrow(() -> new ResourceNotFoundException("DetalleCombo id " + dtcId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdDetalleCombo( Integer dtcId ) {
		return iDetalleComboDAO.findById(dtcId).map(detalleComboRes -> {
			iDetalleComboDAO.delete(detalleComboRes);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("DetalleCombo id " + dtcId  + " no se encuentra"));
	}
	
	public DetalleCombo getByIdDetalleCombo( Integer dtcId ) {
		return iDetalleComboDAO.findById(dtcId).map(detalleComboRes -> {
            return detalleComboRes;
        }).orElseThrow(() -> new ResourceNotFoundException("DetalleCombo id " + dtcId  + " no se encuentra"));
	}
	
	public  List<DetalleCombo> getAllDetalleCombo() {
		return iDetalleComboDAO.findAll();
	}
}
