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
@Table(name = "detalle_combo")
public class DetalleCombo {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "dtc_id")
	private int dtcId;
	
	@Column(name = "dtc_prc")
	private int dtcPrc;
	
	@Column(name = "dtc_cam")
	private int dtcCan;
	
	@ManyToOne
	@JoinColumn( name = "com_dtc_id")
	private Combo combo;

	@ManyToOne
	@JoinColumn( name = "ven_dtc_id")
	private Venta venta;
	
	public int getDtcId() {
		return dtcId;
	}

	public void setDtcId(int dtcId) {
		this.dtcId = dtcId;
	}

	public int getDtcPrc() {
		return dtcPrc;
	}

	public void setDtcPrc(int dtcPrc) {
		this.dtcPrc = dtcPrc;
	}

	public int getDtcCan() {
		return dtcCan;
	}

	public void setDtcCan(int dtcCan) {
		this.dtcCan = dtcCan;
	}

	public Combo getCombo() {
		return combo;
	}

	public void setCombo(Combo combo) {
		this.combo = combo;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

}
