package com.BiblioSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;
@Transactional
@Entity
public class Fanzine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFanzine;
	@Column
	private String nombre;
	@Column
	private Integer ano;
	@Column
	private Integer numero;
	@Column
	private String lugarPublicacion;
	@Column(name = "fechaPrestamo")
	private String fechaPrestamo;
	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Fanzine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fanzine(String nombre, Integer ano,Integer numero, String lugarPublicacion) {
		super();
		this.nombre = nombre;
		this.ano = ano;
		this.numero = numero;
		this.lugarPublicacion = lugarPublicacion;
	}

	

	@Override
	public String toString() {
		return "Fanzine [nombre=" + nombre + ", ano=" + ano + ", numero=" + numero + ", lugarPublicacion="
				+ lugarPublicacion + "]";
	}

	public Long getIdFanzine() {
		return idFanzine;
	}

	public void setIdFanzine(Long idFanzine) {
		this.idFanzine = idFanzine;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getLugarPublicacion() {
		return lugarPublicacion;
	}

	public void setLugarPublicacion(String lugarPublicacion) {
		this.lugarPublicacion = lugarPublicacion;
	}


}
