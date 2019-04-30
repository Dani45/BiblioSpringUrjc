package com.BiblioSpring.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Transactional
@Entity
@Table(name = "user")
@SessionScope
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String email;
	private String passwordHash;

	@ElementCollection(fetch = FetchType.EAGER)
	@JsonIgnore
	private List<String> roles = new ArrayList<String>();

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Libro> libros = new ArrayList<Libro>();

	// comentarios publicados por el usuario
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Revista> revistas = new ArrayList<Revista>();

	// articulos publicados por el usuario
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Pelicula> peliculas = new ArrayList<Pelicula>();
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Fanzine> fancines = new ArrayList<Fanzine>();

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public void addlibros(Libro libro) {
		if (libros == null) {
			libros = new ArrayList<>();
		}
		libros.add(libro);
	}

	public List<Revista> getRevistas() {
		return revistas;
	}

	public void setRevistas(List<Revista> revistas) {
		this.revistas = revistas;
	}

	public void addRevistas(Revista re) {
		if (this.revistas == null) {
			this.revistas = new ArrayList<>();
		}
		this.revistas.add(re);
	}

	public List<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	public void addPeliculas(Pelicula p) {
		if (this.peliculas == null) {
			this.peliculas = new ArrayList<>();
		}
		this.peliculas.add(p);
	}

	public List<Fanzine> getFancines() {
		return fancines;
	}

	public void setFancines(List<Fanzine> fancines) {
		this.fancines = fancines;
	}

	public void addFancines(Fanzine faz) {
		if (this.fancines == null) {
			this.fancines = new ArrayList<>();
		}
		this.fancines.add(faz);
	}

	public User() {
	}

	public User(String name, String password, String email, String... roles) {
		this.name = name;
		this.email = email;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
		// this.libros=new ArrayList<>();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

}