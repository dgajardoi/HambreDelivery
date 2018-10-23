package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.DetalleProducto;
import com.hambre.model.Venta;
import com.hambre.repository.IDetalleProductoDAO;

@Service("detalleProductoService")
public class DetalleProductoService {

	@Autowired
	IDetalleProductoDAO iDetalleProductoDAO;
	
	public DetalleProducto createDetalleProducto( DetalleProducto detalleProducto) {
		return iDetalleProductoDAO.save(detalleProducto);
	}
	
	public DetalleProducto updateDetalleProducto( Integer dtpPrdId, DetalleProducto detalleProducto) {
		return iDetalleProductoDAO.findById(dtpPrdId).map( detalleProductoRes  -> {
			 detalleProductoRes.setDtpPrdPrc(detalleProducto.getDtpPrdPrc());
			 detalleProductoRes.setDtpPrdCan(detalleProducto.getDtpPrdCan());
			 detalleProductoRes.setProducto(detalleProducto.getProducto());
			 detalleProductoRes.setVenta(detalleProducto.getVenta());
			return iDetalleProductoDAO.save(detalleProductoRes);
		}).orElseThrow(() -> new ResourceNotFoundException("DetalleProducto id " + dtpPrdId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdDetalleProducto( Integer dtpPrdId ) {
		return iDetalleProductoDAO.findById(dtpPrdId).map(detalleProductoRes -> {
			iDetalleProductoDAO.delete(detalleProductoRes);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("DetalleProducto id " + dtpPrdId  + " no se encuentra"));
	}
	
	public DetalleProducto getByIdDetalleProducto( Integer dtpPrdId ) {
		return iDetalleProductoDAO.findById(dtpPrdId).map(detalleProductoRes -> {
            return detalleProductoRes;
        }).orElseThrow(() -> new ResourceNotFoundException("DetalleProducto id " + dtpPrdId  + " no se encuentra"));
	}
	
	public  List<DetalleProducto> getAllDetalleProducto() {
		return iDetalleProductoDAO.findAll();
	}
}
