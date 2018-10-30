package com.hambre.dto;

public class ClienteDTO {

	private String telefono;
	
	private String nombre;
	
	private String direccion;
	
	private int comunaId;

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getComunaId() {
		return comunaId;
	}

	public void setComunaId(int comunaId) {
		this.comunaId = comunaId;
	}
	
	
}
