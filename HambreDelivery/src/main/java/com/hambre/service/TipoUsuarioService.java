package com.hambre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hambre.model.TipoUsuario;
import com.hambre.repository.ITipoUsuarioDao;

@Service("tipoUsuarioService")
public class TipoUsuarioService {
	
	@Autowired
	ITipoUsuarioDao iTipoUsuarioDao;
	
	public TipoUsuario createTipoUsuario(TipoUsuario tipoUsuario) {
		return iTipoUsuarioDao.save(tipoUsuario);
	}
	
	public TipoUsuario updateTipoUsuario(TipoUsuario tipoUsuario) {
		return iTipoUsuarioDao.save(tipoUsuario);
	}
	
	public ResponseEntity<?> removeTipoUsuarioId(Integer tipUsuId) {
		return iTipoUsuarioDao.findById(tipUsuId).map(tipoUsuario -> {
			iTipoUsuarioDao.delete(tipoUsuario);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Tipo Usuario Id " + tipUsuId + " no se encuentra"));
	}
	
	public TipoUsuario getByIdTipoUsuario(Integer tipUsuId) {
		return iTipoUsuarioDao.findById(tipUsuId).map(tipoUsuario -> {
            return tipoUsuario;
        }).orElseThrow(() -> new ResourceNotFoundException("Tipo Usuario Id " + tipUsuId + " no se encuentra"));
	}
	
	public  List<TipoUsuario> getAllTipoUsuario() {
		return iTipoUsuarioDao.findAll();
	}
	
	/*
	  @PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable Long postId, @Valid @RequestBody Post postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
            post.setDescription(postRequest.getDescription());
            post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
	 */
}