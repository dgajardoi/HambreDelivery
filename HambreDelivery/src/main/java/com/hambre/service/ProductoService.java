package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Producto;
import com.hambre.repository.IProductoDAO;

@Service("productoService")
public class ProductoService {

	@Autowired
	IProductoDAO iProductoDAO;
	
	public Producto createProducto( Producto producto) {
		return iProductoDAO.save(producto);
	}
	
	public Producto updateProducto( Integer prdId, Producto producto) {
		return iProductoDAO.findById(prdId).map( productoRes  -> {
			productoRes.setPrdNom(producto.getPrdNom());
			productoRes.setPrdPrc(producto.getPrdPrc());
			productoRes.setTipoProducto(producto.getTipoProducto());
			productoRes.setMedida(producto.getMedida());
			return iProductoDAO.save(productoRes);
		}).orElseThrow(() -> new ResourceNotFoundException("Producto id " + prdId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdProducto( Integer prdId ) {
		return iProductoDAO.findById(prdId).map(productoRes -> {
			iProductoDAO.delete(productoRes);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Producto id " + prdId  + " no se encuentra"));
	}
	
	public Producto getByIdProducto( Integer prdId ) {
		return iProductoDAO.findById(prdId).map(productoRes -> {
            return productoRes;
        }).orElseThrow(() -> new ResourceNotFoundException("Producto id " + prdId  + " no se encuentra"));
	}
	
	public  List<Producto> getAllProducto() {
		return iProductoDAO.findAll();
	}
}
