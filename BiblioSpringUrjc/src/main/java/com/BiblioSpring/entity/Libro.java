package com.BiblioSpring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLibro;
	@Column
	private String nombre;
	@Column
	private String autor;
	@Column
	private String lugarPublicacion;
	@Column
	private Date fechaPublicacion;

	public long getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(long idLibro) {
		this.idLibro = idLibro;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getLugarPublicacion() {
		return lugarPublicacion;
	}

	public void setLugarPublicacion(String lugarPublicacion) {
		this.lugarPublicacion = lugarPublicacion;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Libro(String nombre, String autor, String lugarPublicacion, Date fechaPublicacion) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.lugarPublicacion = lugarPublicacion;
		this.fechaPublicacion = fechaPublicacion;
	}

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}



}
