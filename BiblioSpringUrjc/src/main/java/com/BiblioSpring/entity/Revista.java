package com.BiblioSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Transactional
@Entity
public class Revista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRevista;
	@Column
	private String nombre;
	@Column
	private Integer numero;
	@Column
	private Integer ano;
	@Column(name = "fechaPrestamo")
	private String fechaPrestamo;

	public String getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(String fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	@ManyToOne
	@JsonIgnore
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(Long idRevista) {
		this.idRevista = idRevista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Revista [nombre=" + nombre + ", numero=" + numero + ", ano=" + ano + "]";
	}

	public Revista(String nombre, Integer numero, Integer ano) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.ano = ano;
	}

	public Revista() {
		super();
		// TODO Auto-generated constructor stub
	}

}
