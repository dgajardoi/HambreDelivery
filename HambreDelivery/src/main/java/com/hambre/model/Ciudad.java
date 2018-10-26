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
@Table(name = "ciudad")
public class Ciudad {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column( name = "ciu_id")
	private int ciuId;
	
	@Column( name = "ciu_nom")
	private String ciuNom;

	@OneToMany(mappedBy = "ciudad",cascade = CascadeType.ALL)
	private List<Comuna> comuna;
	
	public int getCiuId() {
		return ciuId;
	}

	public void setCiuId(int ciuId) {
		this.ciuId = ciuId;
	}

	public String getCiuNom() {
		return ciuNom;
	}

	public void setCiuNom(String ciuNom) {
		this.ciuNom = ciuNom;
	}
	
	

}
