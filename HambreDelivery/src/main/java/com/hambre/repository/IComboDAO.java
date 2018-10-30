package com.hambre.repository;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hambre.model.Combo;

@Transactional
public interface IComboDAO extends JpaRepository< Combo, Integer>{

	@Query(value="select com_id as comId , com_nom as comNom, com_prc as comPrc, concat(tip_prd_nom, ' ' ,med_nom) as comDes from  tipo_producto, medida, producto, combo, descripcion where tip_prd_id =  tpr_prd_id AND med_id = med_prd_id AND prd_id = prd_des_id AND com_id = com_des_id order by com_id ",nativeQuery=true)
	public List<Object> getDescripcionForAllCombo( );
}
