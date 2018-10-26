package com.hambre.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "tip_usu_id")
	private int tipUsuId;
	
	@Column(name = "tip_usu_nom")
	private String tipUsuNom;
	
	@Column(name = "tip_usu_des")
	private String tipUsuDes;
	
	@OneToMany(mappedBy = "tipoUsuario", cascade = CascadeType.ALL)
	private List<Usuario> usuario;

	public int getTipUsuId() {
		return tipUsuId;
	}

	public void setTipUsuId(int tipUsuId) {
		this.tipUsuId = tipUsuId;
	}

	public String getTipUsuNom() {
		return tipUsuNom;
	}

	public void setTipUsuNom(String tipUsuNom) {
		this.tipUsuNom = tipUsuNom;
	}

	public String getTipUsuDes() {
		return tipUsuDes;
	}

	public void setTipUsuDes(String tipUsuDes) {
		this.tipUsuDes = tipUsuDes;
	}
	 @Override
	    public String toString() {
	        String result = String.format(
	                "Tipo de Usuario [id=%d, nombre='%s', descripcion = '%s']%n",
	               this.tipUsuId , this.tipUsuNom, this.tipUsuDes);
	        if (usuario != null) {
	            for(Usuario user : usuario) {
	                result += String.format(
	                        "Usuario[id=%d, nombre='%s', password='%s', idTipo='%s']%n",
	                        user.getUsuId(), user.getUsuNom(), user.getUsuPas(), user.getTipoUsuario());
	            }
	        }

	        return result;
	    }
	
}
