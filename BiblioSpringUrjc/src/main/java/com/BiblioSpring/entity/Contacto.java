package com.BiblioSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.transaction.Transactional;
@Transactional
@Entity
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idContacto;
	@Column
	private String nombre;
	@Column
	private String correo;
	@Column
	private String asunto;
	@Column
	private String comentario;

	

	public long getIdContacto() {
		return idContacto;
	}

	public void setIdContacto(long idContacto) {
		this.idContacto = idContacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	// to string + constructor
	public Contacto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contacto(String nombre, String correo, String asunto, String comentario) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.asunto = asunto;
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Contacto  nombre=" + nombre + ", correo=" + correo + ", asunto=" + asunto + ", comentario=" + comentario
				+ "]";
	}

}
