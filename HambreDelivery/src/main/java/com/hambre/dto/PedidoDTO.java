package com.hambre.dto;

import java.util.List;

public class PedidoDTO {

	private int precioTotal;
	
	private int clientId;
	
	private int usuarioId;
	
	private List<ComboDTO> comboDTO;
	
	private List<ProductoDTO> productoDTO;

	public int getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}

	public List<ComboDTO> getComboDTO() {
		return comboDTO;
	}

	public void setComboDTO(List<ComboDTO> comboDTO) {
		this.comboDTO = comboDTO;
	}

	public List<ProductoDTO> getProductoDTO() {
		return productoDTO;
	}

	public void setProductoDTO(List<ProductoDTO> productoDTO) {
		this.productoDTO = productoDTO;
	}
	
	
}
