package com.hambre.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		producto.setPrdNom(producto.getTipoProducto().getTipPrdNom() + " " + producto.getMedida().getMedNom());
		return iProductoDAO.save(producto);
	}
	
	public List<Map<String, Object>> getProductosPedido() {
		List<Object> obj = new ArrayList<>();
		List<Map<String, Object>> listMap = new ArrayList<>();
		obj = iProductoDAO.getProductosPedido();
		for(int i = 0 ; i < obj.size() ; i++) {
			Object[] row = (Object[]) obj.get(i);
			Map<String, Object> map = new HashMap<>();
			map.put("prdId", row[0]);
			map.put("prdNom", row[1]);
			map.put("prdPrc", row[2]);
			listMap.add(map);
		}
		return listMap;
	}
	public Producto updateProducto( Integer prdId, Producto producto) {
		return iProductoDAO.findById(prdId).map( productoRes  -> {
			productoRes.setPrdNom(producto.getTipoProducto().getTipPrdNom() + " " +producto.getMedida().getMedNom());
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
