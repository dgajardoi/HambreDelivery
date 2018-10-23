package com.hambre.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@Column(name = "cli_id")
	private int cliId;
	
	@Column(name = "cli_tel")
	private String cliTel;
	
	@Column(name = "cli_nom")
	private String cliNom;
	
	@Column(name = "cli_dir")
	private String cliDir;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<Venta> venta;

	public int getCliId() {
		return cliId;
	}

	public void setCliId(int cliId) {
		this.cliId = cliId;
	}

	public String getCliTel() {
		return cliTel;
	}

	public void setCliTel(String cliTel) {
		this.cliTel = cliTel;
	}

	public String getCliNom() {
		return cliNom;
	}

	public void setCliNom(String cliNom) {
		this.cliNom = cliNom;
	}

	public String getCliDir() {
		return cliDir;
	}

	public void setCliDir(String cliDir) {
		this.cliDir = cliDir;
	}
	
}
