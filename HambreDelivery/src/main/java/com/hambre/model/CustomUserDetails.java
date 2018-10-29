package com.hambre.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails extends Usuario implements UserDetails{

	public CustomUserDetails(final Usuario usuario) {
		super(usuario);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getGrantedAuthorities(getRoles(this.getTipoUsuario().getTipUsuId()));
	}
	public List<String> getRoles(Integer role) {

		List<String> roles = new ArrayList<>();

		if (role.intValue() == 1) {
			roles.add("ROLE_Administrador");
		} else if (role.intValue() == 2) {
			roles.add("ROLE_Operador");
		}
		return roles;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return super.getUsuPas();
	}

	@Override
	public String getUsername() {
		return super.getUsuNom();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
