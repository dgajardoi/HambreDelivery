package com.hambre.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hambre.repository.IUsuarioDAO;
import com.hambre.service.CustomUserDetailsService;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses = IUsuarioDAO.class)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	CustomUserDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(getPasswordEncoder());
	}
	
@Override
protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable();
	http.authorizeRequests()
		.antMatchers("/usuarios/**").authenticated()
		.anyRequest().permitAll()
		.and().formLogin().permitAll();
	//super.configure(http);
}
	
	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder(){	
			@Override
			public boolean matches(CharSequence rawPassword, String encodedPassword) {
				if(rawPassword.equals(encodedPassword)) {
					return true;
				}
				else {
					return false;
				}
			}
			
			@Override
			public String encode(CharSequence rawPassword) {
				return rawPassword.toString();
			}
		};
	}
}
