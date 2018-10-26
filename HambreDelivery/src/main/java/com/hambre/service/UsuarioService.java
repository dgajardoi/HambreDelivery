package com.hambre.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.dto.UserDTO;
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
	
	public UserDTO createUsuario(UserDTO usuario) {
		TipoUsuario tipoUsu = new TipoUsuario();
		tipoUsu.setTipUsuId(usuario.getTipoUser());
		Usuario admin = getByIdUsuario(usuario.getAdminId());
		System.out.println("Admin bd:" + admin.getUsuId());
		if(admin != null) {
			Optional<TipoUsuario> tipoUsAdmin = iTipoUsuarioDao.findById(admin.getTipoUsuario().getTipUsuId());
			System.out.println("tipoAdminBD:" + tipoUsAdmin.get().getTipUsuNom());
			System.out.println("Es admin:" + tipoUsAdmin.get().getTipUsuNom().toUpperCase().trim().equals("ADMINISTRADOR"));
			if(tipoUsAdmin.get().getTipUsuNom().toUpperCase().trim().equals("ADMINISTRADOR") && admin.getUsuPas().trim().equals(usuario.getPasswordAdmin().trim())){
				return iTipoUsuarioDao.findById(tipoUsu.getTipUsuId()).map(tipoUsuario -> {
					System.out.println("tipoUsuario:" + tipoUsuario.getTipUsuNom());
					Usuario usuarioModel = new Usuario();
					usuarioModel.setTipoUsuario(tipoUsuario);
					usuarioModel.setUsuNom(usuario.getNombreUser());
					usuarioModel.setUsuPas(usuario.getPassword());
					System.out.println("usuarioModel:" + usuarioModel.getUsuNom());
				    iUsuarioDAO.save(usuarioModel);    
				    return usuario;
			}).orElseThrow(() -> new ResourceNotFoundException("Tipo Usuario Id " + usuario.getTipoUser() + " no se encuentra"));
			
			}
			else {
				return null;
			}
		}
		return null;
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
