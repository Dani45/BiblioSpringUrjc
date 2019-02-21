package com.ejemplo.entity;

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
// relacion de fanzine
	@OneToOne
	private Fanzine fanzine;
	@OneToOne
	private Revista revista;
	@OneToOne
	private Pelicula pelicula;

	@Override
	public String toString() {
		return "Alternativa [idAlternativa=" + idAlternativa + ", fanzine=" + fanzine + ", revista=" + revista
				+ ", pelicula=" + pelicula + "]";
	}

	public long getIdAlternativa() {
		return idAlternativa;
	}

	public void setIdAlternativa(long idAlternativa) {
		this.idAlternativa = idAlternativa;
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

	public Alternativa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Alternativa(long idAlternativa, Fanzine fanzine, Revista revista, Pelicula pelicula) {
		super();
		this.idAlternativa = idAlternativa;
		this.fanzine = fanzine;
		this.revista = revista;
		this.pelicula = pelicula;
	}

}
