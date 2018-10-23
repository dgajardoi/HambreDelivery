package com.hambre.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_producto")
public class TipoProducto {

	@Id
	@Column(name = "tip_prd_id")
	private int tipPrdId;
	
	@Column(name = "tip_prd_nom")
	private String tipPrdNom;
	
	@OneToMany(mappedBy = "tipoProducto", cascade = CascadeType.ALL)
	private List<Producto> producto;

	public int getTipPrdId() {
		return tipPrdId;
	}

	public void setTipPrdId(int tipPrdId) {
		this.tipPrdId = tipPrdId;
	}

	public String getTipPrdNom() {
		return tipPrdNom;
	}

	public void setTipPrdNom(String tipPrdNom) {
		this.tipPrdNom = tipPrdNom;
	}
	
	/*
	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}*/
	
	
}
