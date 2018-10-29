package com.hambre.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hambre.model.CustomUserDetails;
import com.hambre.model.Usuario;
import com.hambre.repository.IUsuarioDAO;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	IUsuarioDAO iUsuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = iUsuarioDAO.findByName(username);
		usuario
			.orElseThrow(() -> new UsernameNotFoundException("Username no existe"));
		return usuario.map(CustomUserDetails::new).get() ;
	}

}
