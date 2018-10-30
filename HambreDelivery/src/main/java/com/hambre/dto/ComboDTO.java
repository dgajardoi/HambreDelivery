package com.hambre.dto;

public class ComboDTO {
	private int comboId;
	private int comboPrecio;
	private int comboCantidad;
	private String comboNombre;

	
	public int getComboId() {
		return comboId;
	}
	public void setComboId(int comboId) {
		this.comboId = comboId;
	}
	public String getComboNombre() {
		return comboNombre;
	}
	public void setComboNombre(String comboNombre) {
		this.comboNombre = comboNombre;
	}
	public int getComboPrecio() {
		return comboPrecio;
	}
	public void setComboPrecio(int comboPrecio) {
		this.comboPrecio = comboPrecio;
	}
	public int getComboCantidad() {
		return comboCantidad;
	}
	public void setComboCantidad(int comboCantidad) {
		this.comboCantidad = comboCantidad;
	}

	
}
