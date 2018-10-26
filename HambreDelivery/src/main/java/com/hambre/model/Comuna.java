package com.hambre.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "comuna")
public class Comuna {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column( name = "cmn_id")
	private int cmnId;
	
	@Column( name = "cmn_nom")
	private String cmnNom;
	
	@ManyToOne
	@JoinColumn( name = "ciu_cmn_id")
	private Ciudad ciudad;
	
	@OneToMany( mappedBy = "comuna", cascade = CascadeType.ALL)
	private List<Cliente> cliente;

	public int getCmnId() {
		return cmnId;
	}

	public void setCmnId(int cmnId) {
		this.cmnId = cmnId;
	}

	public String getCmnNom() {
		return cmnNom;
	}

	public void setCmnNom(String cmnNom) {
		this.cmnNom = cmnNom;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	

}
