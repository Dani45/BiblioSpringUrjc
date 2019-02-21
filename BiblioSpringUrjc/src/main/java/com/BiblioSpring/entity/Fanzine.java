package com.BiblioSpring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fanzine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idFanzine;
	@Column
	private String nombre;
	@Column
	private Integer ano;
	@Column
	private String tipo; // para saber si es fisico o digital

	@OneToOne
	private Alternativa alternativa;

	public Fanzine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fanzine(String nombre, Integer ano, String tipo) {
		super();
		this.nombre = nombre;
		this.ano = ano;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Fanzine [nombre=" + nombre + ", ano=" + ano + ", tipo=" + tipo + "]";
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
