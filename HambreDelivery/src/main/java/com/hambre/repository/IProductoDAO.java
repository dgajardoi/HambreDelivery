package com.hambre.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hambre.model.Producto;

@Transactional
public interface IProductoDAO extends JpaRepository<Producto, Integer>{
	
	@Query(value = "select prd_id, prd_nom, prd_prc from  tipo_producto, medida, producto where tip_prd_id =  tpr_prd_id AND med_id = med_prd_id order by prd_id", nativeQuery=true)
	public List<Object> getProductosPedido();

}
