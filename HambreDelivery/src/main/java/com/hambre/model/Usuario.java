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
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "usu_id")
	private int usuId;
	
	@Column(name = "usu_nom")
	private String usuNom;
	
	@Column(name = "usu_pas")
	private String usuPas;
	
	@ManyToOne
	@JoinColumn(name = "tus_usu_id")
	private TipoUsuario tipoUsuario;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Venta> ventas;
	
	public int getUsuId() {
		return usuId;
	}

	public void setUsuId(int usuId) {
		this.usuId = usuId;
	}

	public String getUsuNom() {
		return usuNom;
	}

	public void setUsuNom(String usuNom) {
		this.usuNom = usuNom;
	}

	public String getUsuPas() {
		return usuPas;
	}

	public void setUsuPas(String usuPas) {
		this.usuPas = usuPas;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
