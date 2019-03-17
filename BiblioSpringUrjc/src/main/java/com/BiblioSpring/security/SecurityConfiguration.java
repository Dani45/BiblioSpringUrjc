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
		http.authorizeRequests().antMatchers("/BiblioSpring/Libro").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Categoria").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Alternativas").permitAll();
		
		http.authorizeRequests().antMatchers("/BiblioSpring/Contacto").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Fanzine").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Pelicula").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/Revista").permitAll();

		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/BiblioSpring/Login").permitAll();
		http.authorizeRequests().antMatchers("/new_user").permitAll();
		http.authorizeRequests().antMatchers("/BiblioSpring/loginError").permitAll();
		
        http.authorizeRequests().antMatchers("/BiblioSpring/Prestamo").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/BiblioSpring/Administrador").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/BiblioSpring/Libro/AddLibro").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/BiblioSpring/Categoria/AddCategoria").hasAnyRole("ADMIN");
		http.authorizeRequests().antMatchers("/BiblioSpring/DeleteCategoria").hasAnyRole("ADMIN");
		
		// Login form
		http.formLogin().loginPage("/BiblioSpring/Login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		// en caso del correcto inicio de sesion
        http.formLogin().defaultSuccessUrl("/BiblioSpring/login/true");
        // en caso del incorrecto inicio de sesion
        http.formLogin().failureUrl("/BiblioSpring/login/false");

		// Logout
		http.logout().logoutUrl("/BiblioSpring/Logout");
		http.logout().logoutSuccessUrl("/");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
	}
}