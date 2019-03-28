package com.BiblioSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pelicula{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPelicula;
	@Column
	private String nombre;
	@Column
	private Integer ano;
	@Column
	private String lugarPublicacion;
	

	public Pelicula() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pelicula(String nombre, Integer ano, String lugarPublicacion) {
		super();
		this.nombre = nombre;
		this.ano = ano;
		this.lugarPublicacion = lugarPublicacion;
	}

	@Override
	public String toString() {
		return "Fanzine [nombre=" + nombre + ", ano=" + ano +  ", lugarPublicacion="
				+ lugarPublicacion + "]";
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

	

	public String getLugarPublicacion() {
		return lugarPublicacion;
	}

	public void setLugarPublicacion(String lugarPublicacion) {
		this.lugarPublicacion = lugarPublicacion;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}


}
