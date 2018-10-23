package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.TipoUsuario;
import com.hambre.model.Usuario;
import com.hambre.repository.ITipoUsuarioDao;
import com.hambre.repository.IUsuarioDAO;

@Service("usuarioService")
public class UsuarioService {

	@Autowired
	ITipoUsuarioDao iTipoUsuarioDao;
	
	@Autowired
	IUsuarioDAO iUsuarioDAO;
	
	public Usuario createUsuario(Usuario usuario) {
		
		return iTipoUsuarioDao.findById(usuario.getTipoUsuario().getTipUsuId()).map(tipoUsuario -> {
			return iUsuarioDAO.save(usuario);
		}).orElseThrow(() -> new ResourceNotFoundException("Tipo Usuario Id " + usuario.getTipoUsuario().getTipUsuId() + " no se encuentra"));
	}
	
	public Usuario updateUsuario(Usuario usuario) {
		return iUsuarioDAO.save(usuario);
	}
	
	public ResponseEntity<?> removeUsuarioId(Integer usuId) {
		return iUsuarioDAO.findById(usuId).map(usuario -> {
			iUsuarioDAO.delete(usuario);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Usuario Id " + usuId + " no se encuentra"));
	}
	
	public Usuario getByIdUsuario(Integer usuId) {
		return iUsuarioDAO.findById(usuId).map(usuario -> {
            return usuario;
        }).orElseThrow(() -> new ResourceNotFoundException("Usuario Id " + usuId + " no se encuentra"));
	}
	
	public  List<Usuario> getAllTipoUsuario() {
		return iUsuarioDAO.findAll();
	}
}
