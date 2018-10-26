package com.hambre.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "descripcion")
public class Descripcion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column( name = "des_id")
	private int desId;
	
	@ManyToOne
	@JoinColumn( name = "prd_des_id")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn( name = "com_des_id")
	private Combo combo;

	public int getDesId() {
		return desId;
	}

	public void setDesId(int desId) {
		this.desId = desId;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}
	
}
