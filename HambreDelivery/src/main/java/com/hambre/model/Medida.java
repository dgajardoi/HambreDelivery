package com.hambre.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "medida")
public class Medida {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column( name = "med_id")
	private int medId;
	
	@Column (name = "med_nom")
	private String medNom;
	
	@OneToMany(mappedBy = "medida", cascade = CascadeType.ALL)
	private List<Producto> producto;
	
	public int getMedId() {
		return medId;
	}

	public void setMedId(int medId) {
		this.medId = medId;
	}

	public String getMedNom() {
		return medNom;
	}

	public void setMedNom(String medNom) {
		this.medNom = medNom;
	}

	/*@OneToMany(mappedBy = "medida", cascade = CascadeType.ALL)
	public List<Producto> getProducto() {
		return producto;
	}

	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}*/

	
}
