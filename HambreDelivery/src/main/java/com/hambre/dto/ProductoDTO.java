package com.hambre.dto;

public class ProductoDTO {

	private int productoId;
	
	private int productoPrecio;
	
	private int productoCantidad;
	
	private String productoNombre;

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

	public int getProductoPrecio() {
		return productoPrecio;
	}

	public void setProductoPrecio(int productoPrecio) {
		this.productoPrecio = productoPrecio;
	}

	public int getProductoCantidad() {
		return productoCantidad;
	}

	public void setProductoCantidad(int productoCantidad) {
		this.productoCantidad = productoCantidad;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}
	
}
