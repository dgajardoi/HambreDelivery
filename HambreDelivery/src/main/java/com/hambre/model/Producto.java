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

import org.assertj.core.description.Description;

@Entity
@Table( name = "producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column( name = "prd_id")
	private int prdId;
	
	@Column( name = "prd_nom")
	private String prdNom;
	
	@Column( name = "prd_prc")
	private int prdPrc;
	
	@ManyToOne
	@JoinColumn( name = "tpr_prd_id")
	private TipoProducto tipoProducto;
	
	@ManyToOne
	@JoinColumn( name = "med_prd_id")
	private Medida medida;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL )
	private List<Descripcion> descripcion;
	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL )
	private List<DetalleProducto> detalleProducto;
	
	public int getPrdId() {
		return prdId;
	}

	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}

	public String getPrdNom() {
		return prdNom;
	}

	public void setPrdNom(String prdNom) {
		this.prdNom = prdNom;
	}

	public int getPrdPrc() {
		return prdPrc;
	}

	public void setPrdPrc(int prdPrc) {
		this.prdPrc = prdPrc;
	}

	public TipoProducto getTipoProducto() {
		return tipoProducto;
	}

	public void setTipoProducto(TipoProducto tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

}
