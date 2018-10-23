package com.hambre.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {
	
	@Id
	@Column( name = "ven_id")
	private int venId;
	
	@Column( name = "ven_prc_tot")
	private int venPrcTot;

	@Column( name = "ven_fch")
	private Date venFch;
	
	@ManyToOne
	@JoinColumn( name = "cli_ven_id")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn( name = "usu_ven_id")
	private Usuario usuario;
	
	@OneToMany( mappedBy = "venta", cascade = CascadeType.ALL)
	private List<DetalleCombo> detalleCombo;
	
	@OneToMany( mappedBy = "venta", cascade = CascadeType.ALL)
	private List<DetalleProducto> detalleProducto;

	public int getVenId() {
		return venId;
	}

	public void setVenId(int venId) {
		this.venId = venId;
	}

	public int getVenPrcTot() {
		return venPrcTot;
	}

	public void setVenPrcTot(int venPrcTot) {
		this.venPrcTot = venPrcTot;
	}

	public Date getVenFch() {
		return venFch;
	}

	public void setVenFch(Date venFch) {
		this.venFch = venFch;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
