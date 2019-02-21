package com.BiblioSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPelicula;
	@Column
	private String nombre;
	@Column
	private String autor;
	@Column
	private Integer ano;
	@Column
	private String tipo;
	@OneToOne
	private Alternativa alternativa;

	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pelicula(String nombre, String autor, Integer ano, String tipo) {
		super();
		this.nombre = nombre;
		this.autor = autor;
		this.ano = ano;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Pelicula [nombre=" + nombre + ", autor=" + autor + ", ano=" + ano + ", tipo=" + tipo + "]";
	}

	public Long getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(Long idPelicula) {
		this.idPelicula = idPelicula;
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

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}

}
