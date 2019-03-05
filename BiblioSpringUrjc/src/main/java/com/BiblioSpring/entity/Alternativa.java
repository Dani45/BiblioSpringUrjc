package com.BiblioSpring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAlternativa;

	@Column
	private String alternativa;
	
	@OneToOne
	private Fanzine fanzine;
	@OneToOne
	private Revista revista;
	@OneToOne
	private Pelicula pelicula;


	public Alternativa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alternativa(String alternativa) {
		super();
		this.alternativa = alternativa;
	}
	public long getIdAlternativa() {
		return idAlternativa;
	}
	public void setIdAlternativa(long idAlternativa) {
		this.idAlternativa = idAlternativa;
	}
	public String getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(String alternativa) {
		this.alternativa = alternativa;
	}
	public Fanzine getFanzine() {
		return fanzine;
	}
	public void setFanzine(Fanzine fanzine) {
		this.fanzine = fanzine;
	}
	public Revista getRevista() {
		return revista;
	}
	public void setRevista(Revista revista) {
		this.revista = revista;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	@Override
	public String toString() {
		return "Alternativa [alternativa=" + alternativa + ", fanzine=" + fanzine + ", revista=" + revista
				+ ", pelicula=" + pelicula + "]";
	}
	
	

}
