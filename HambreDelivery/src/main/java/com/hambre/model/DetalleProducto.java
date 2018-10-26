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
@Table(name = "detalle_producto")
public class DetalleProducto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column( name = "dtp_prd_id")
	private int dtpPrdId;
	
	@Column( name = "dtp_prd_prc")
	private int dtpPrdPrc;
	
	@Column( name = "dtp_prd_can")
	private int dtpPrdCan;
	
	@ManyToOne
	@JoinColumn(name = "prd_dtp_id")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn( name = "ven_dtp_id")
	private Venta venta;

	public int getDtpPrdId() {
		return dtpPrdId;
	}

	public void setDtpPrdId(int dtpPrdId) {
		this.dtpPrdId = dtpPrdId;
	}

	public int getDtpPrdPrc() {
		return dtpPrdPrc;
	}

	public void setDtpPrdPrc(int dtpPrdPrc) {
		this.dtpPrdPrc = dtpPrdPrc;
	}

	public int getDtpPrdCan() {
		return dtpPrdCan;
	}

	public void setDtpPrdCan(int dtpPrdCan) {
		this.dtpPrdCan = dtpPrdCan;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	

}
