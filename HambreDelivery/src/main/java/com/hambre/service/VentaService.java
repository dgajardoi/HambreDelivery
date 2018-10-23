package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Venta;
import com.hambre.repository.IVentaDAO;

@Service("ventaService")
public class VentaService {

	@Autowired
	IVentaDAO iVentaDAO;
	
	public Venta createVenta( Venta venta) {
		return iVentaDAO.save(venta);
	}
	
	public Venta updateVenta( Integer venId, Venta venta) {
		return iVentaDAO.findById(venId).map( ventaRes  -> {
			ventaRes.setVenPrcTot(venta.getVenPrcTot());//No debería poder modificar el precio total, ya que este se genera con los detalles
			ventaRes.setVenFch(venta.getVenFch());
			ventaRes.setCliente(venta.getCliente());
			ventaRes.setUsuario(venta.getUsuario());
			return iVentaDAO.save(ventaRes);
		}).orElseThrow(() -> new ResourceNotFoundException("Venta id " + venId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdVenta( Integer venId ) {
		return iVentaDAO.findById(venId).map(ventaRes -> {
			iVentaDAO.delete(ventaRes);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Venta id " + venId  + " no se encuentra"));
	}
	
	public Venta getByIdVenta( Integer venId ) {
		return iVentaDAO.findById(venId).map(ventaRes -> {
            return ventaRes;
        }).orElseThrow(() -> new ResourceNotFoundException("Venta id " + venId  + " no se encuentra"));
	}
	
	public  List<Venta> getAllVenta() {
		return iVentaDAO.findAll();
	}
}
