package com.hambre.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.Combo;
import com.hambre.repository.IComboDAO;

@Service("comboService")
public class ComboService {

	@Autowired
	IComboDAO iComboDAO;
	
	public Combo createCombo( Combo combo) {
		return iComboDAO.save(combo);
	}
	
	public List<Map<String, Object>> getDescripcionForAllCombo( ) {
		List<Object> obj = new ArrayList<>();
		List<Map<String, Object>> listMap = new ArrayList<>();
		obj = iComboDAO.getDescripcionForAllCombo();
		System.out.println("largo1:" + obj.size());
		System.out.println(obj.get(0).toString().charAt(0));
		if(obj.size() > 0) {
			Object[] row = (Object[]) obj.get(0);
			Map<String, Object> map = new HashMap<>();
			map.put("comId", row[0]);
			map.put("comNom", row[1]);
			map.put("comPrc", row[2]);
			map.put("tipPrdNom", row[3]);
			map.put("medNom", row[4]);
			map.put("comDes", row[3]  + " "  + row[4] );
			for(int i = 1 ; i < obj.size() ; i++) {
				row = (Object[]) obj.get(i);
				if(map.get("comId") ==  row[0]) {
					map.put("comDes", map.get("comDes")+ " + " + row[3]  + " "  + row[4] );
				}
				else {
					listMap.add(map);
					System.out.println(map);
					map = new HashMap<>();
					map.put("comId", row[0]);
					map.put("comNom", row[1]);
					map.put("comPrc", row[2]);
					map.put("tipPrdNom", row[3]);
					map.put("medNom", row[4]);
					map.put("comDes", row[3]  + " "  + row[4] );
				}
				
			}
			listMap.add(map);
		}
		System.out.println(listMap);
		return listMap;
	}
	
	public Combo updateCombo( Integer comId, Combo combo) {
		return iComboDAO.findById(comId).map(comboRes -> { 
			comboRes.setComNom(combo.getComNom());
			comboRes.setComPrc(combo.getComPrc());
			return iComboDAO.save(comboRes);
		}).orElseThrow(() -> new ResourceNotFoundException("Combo id " + comId  + " no existe"));
	}
	
	public ResponseEntity<?> removeByIdCombo(Integer comId) {
		return iComboDAO.findById(comId).map(tipProd -> {
			iComboDAO.delete(tipProd);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Combo id " + comId  +  " no se encuentra"));
	}
	
	public Combo getByIdCombo(Integer comId) {
		return iComboDAO.findById(comId).map(tipProd -> {
            return tipProd;
        }).orElseThrow(() -> new ResourceNotFoundException("Combo id " + comId  +  " no se encuentra"));
	}
	
	public  List<Combo> getAllCombo() {
		return iComboDAO.findAll();
	}
	
}
