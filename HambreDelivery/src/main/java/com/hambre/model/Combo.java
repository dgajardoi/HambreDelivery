package com.hambre.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "combo" )
public class Combo {
	
	@Id
	@Column( name = "com_id")
	private int comId;
	
	@Column( name = "com_nom")
	private String comNom;
	
	@Column( name = "com_prc")
	private int comPrc;
	
	@OneToMany(mappedBy = "combo", cascade = CascadeType.ALL)
	private List<Descripcion> descripcion;
	
	@OneToMany(mappedBy = "combo", cascade = CascadeType.ALL)
	private List<DetalleCombo> detalleCombo;

	public int getComId() {
		return comId;
	}

	public void setComId(int comId) {
		this.comId = comId;
	}

	public String getComNom() {
		return comNom;
	}

	public void setComNom(String comNom) {
		this.comNom = comNom;
	}

	public int getComPrc() {
		return comPrc;
	}

	public void setComPrc(int comPrc) {
		this.comPrc = comPrc;
	}
	

}
