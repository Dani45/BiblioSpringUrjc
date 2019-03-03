package com.BiblioSpring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		http.authorizeRequests().antMatchers("/BiblioSpring").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Libro/**").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Categoria/**").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Alternativas/**").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Prestamo").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Contacto").permitAll();

		http.authorizeRequests().antMatchers("/BiblioSpring/Login").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Register").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/loginError").permitAll();

		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/BiblioSpring/Administrador").hasAnyRole("ADMIN");
		// http.authorizeRequests().antMatchers("/Admin").hasAnyRole("ADMIN");
		http.authorizeRequests().anyRequest().authenticated();
		// Login form
		http.formLogin().loginPage("/BiblioSpring/Login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/BiblioSpring");
		http.formLogin().failureUrl("/BiblioSpring/LoginError");

		// Logout
		http.logout().logoutUrl("/BiblioSpring/Logout");
		http.logout().logoutSuccessUrl("/BiblioSpring");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
	}
}
